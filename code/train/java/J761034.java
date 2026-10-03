import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Random;

import javax.management.RuntimeErrorException;
 
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		ContestScanner scan = new ContestScanner();
		
		(new Solve(scan.nextToken())).solve();
	}
}
class Solve {
	public String S;
	
	public Solve(String S)
	{
		this.S = S;
	}
	
	public void solve()
	{
		long ans = 0;
		int length = S.length();
		
		Character[] SChars = ArrayIterable.toCharacterArray(S.toCharArray());
		
		RollingHash rh = new RollingHash(new ArrayIterable<Character>(SChars), length);
		RollingHash rht = new RollingHash(new ArrayIterable<Character>(SChars) {
			@Override
			public Iterator<Character> iterator() {
				final Character[] arr = this.arr;
				return new Iterator<Character>() {
					private int i;
					{
						i = arr.length - 1;
					}
					public boolean hasNext()
					{
						return i >= 0;
					}
					
					public Character next()
					{
						return arr[i--];
					}
					
					public void remove()
					{
						return;
					}
				};
			}
		}, length);
		
		for(int rp = length - 1 - (length - 3) / 2; rp < length - 1; rp++)
		{
			int Alen = searchAlen(rh, length, rp);
			int Clen = searchClen(rht, length, rp);
			
			ans += Math.max(0, Alen + Clen - (length - rp - 1));
		}
		
		System.out.println(ans);
	}
	
	protected int searchAlen(final RollingHash rh, final int length, final int rp)
	{
		int low = 0, high = length - rp + 1;
		
		while(high - low > 1)
		{
			final int med = (low + high) / 2;

			if(rh.hash(med).equals(rh.hash(rp, rp + med))) low = med;
			else high = med;
		}
		return Math.min(low, length - rp - 1);
	}

	protected int searchClen(final RollingHash rh, final int length, final int rp)
	{
		int low = 0, high = length - rp + 1;
		
		while(high - low > 1)
		{
			final int med = (low + high) / 2;
			
			if(rh.hash(med).equals(rh.hash(length - rp, length - rp + med))) low = med;
			else high = med;
		}
		return Math.min(low, length - rp - 1);
	}
}
class RollingHash {
	private static long[] mul;
	private static long[] mod;
	private long[][] pow;
	private long[][] hash;
	
	static {
		Random rnd = new Random();
		mul = new long[] { 10037, 10097 };
		mod = new long[] { 1000000007, 1000000009 };
	}
	
	public RollingHash(Iterable<Character> S, int size)
	{
		this.pow = new long[2][size + 1];
		this.hash = new long[2][size + 1];
		
		for(int i=0; i < 2; i++)
		{
			this.pow[i][0] = 1;
			this.hash[i][0] = 0;
		}
		
		for(int i=0; i < 2; i++)
		{
			Iterator<Character> it = S.iterator();
			
			for(int j=0; it.hasNext(); j++)
			{
				char c = it.next();

				this.pow[i][j+1] = (this.pow[i][j] * mul[i]) % mod[i];
				this.hash[i][j+1] = ((long)c + this.hash[i][j] * mul[i]) % mod[i];
			}
		}
	}
	
	public Pair<Long> hash(int size)
	{
		return new Pair<Long>(this.hash[0][size], this.hash[1][size]);
	}
	
	public Pair<Long> hash(int l, int r)
	{
		long h1 = (this.hash[0][r] - (BigInteger.valueOf(this.hash[0][l])
										.multiply(BigInteger.valueOf(this.pow[0][r-l]))
										.mod(BigInteger.valueOf(mod[0])).longValue()) + mod[0]) % mod[0];
		
		long h2 = (this.hash[1][r] - (BigInteger.valueOf(this.hash[1][l])
										.multiply(BigInteger.valueOf(this.pow[1][r-l]))
										.mod(BigInteger.valueOf(mod[1])).longValue()) + mod[1]) % mod[1];

		return new Pair<Long>(h1, h2);
	}
}
class Pair<T> {
	public final T fst;
	public final T snd;
	
	public Pair(T f, T s)
	{
		fst = f;
		snd = s;
	}
	
	public boolean equals(Pair<T> o)
	{
		return (this.fst.equals(o.fst)) && (this.snd.equals(o.snd));
	}
}

class ArrayIterable<T> implements Iterable<T>
{
	protected T[] arr;
	
	public ArrayIterable(T[] arr)
	{
		this.arr = arr.clone();
	}
	
	public static Boolean[] toBooleanArray(boolean[] arr)
	{
		Boolean[] converted = new Boolean[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Character[] toCharacterArray(char[] arr)
	{
		Character[] converted = new Character[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Byte[] toByteArray(byte[] arr)
	{
		Byte[] converted = new Byte[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Short[] toShortArray(short[] arr)
	{
		Short[] converted = new Short[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Integer[] toIntegerArray(int[] arr)
	{
		Integer[] converted = new Integer[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Long[] toLongArray(long[] arr)
	{
		Long[] converted = new Long[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Float[] toFloatArray(float[] arr)
	{
		Float[] converted = new Float[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public static Double[] toDoubleArray(double[] arr)
	{
		Double[] converted = new Double[arr.length];
		
		for(int i=0, len = arr.length; i < len; i++)
		{
			converted[i] = arr[i];
		}
		
		return converted;
	}
	
	public Iterator<T> iterator()
	{
		return new Iterator<T>() {
			private int i;
			
			public boolean hasNext()
			{
				return i < arr.length;
			}
			
			public T next()
			{
				return arr[i++];
			}
			
			public void remove()
			{
				return;
			}
		};
	}
}
class ContestScanner {
	BufferedReader reader;
	String[] line;
	int index;
	public ContestScanner() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public ContestScanner(String filename) throws FileNotFoundException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
	}
	
	public String nextToken() throws IOException {
		if(line == null || index >= line.length)
		{
			line = reader.readLine().trim().split(" ");
			index = 0;
		}
		
		return line[index++];
	}
	
	public String next() throws IOException {
		return nextToken();
	}
	
	public String readLine() throws IOException {
		line = null;
		index = 0;
		
		return reader.readLine();
	}
	
	public int nextInt() throws IOException, NumberFormatException {
		return Integer.parseInt(nextToken());
	}
	
	public long nextLong() throws IOException, NumberFormatException {
		return Long.parseLong(nextToken());
	}
	
	public double nextDouble() throws IOException, NumberFormatException {
		return Double.parseDouble(nextToken());
	}
	
	public int[] nextIntArray(int N) throws IOException, NumberFormatException {
		int[] result = new int[N];
		
		for(int i=0; i < N; i++) result[i] = nextInt();
		
		return result;
	}
	
	public long[] nextLongArray(int N) throws IOException, NumberFormatException {
		long[] result = new long[N];
		
		for(int i=0; i < N; i++) result[i] = nextLong();
		
		return result;
	}
	
	public double[] nexDoubleArray(int N) throws IOException, NumberFormatException {
		double[] result = new double[N];
		
		for(int i=0; i < N; i++) result[i] = nextDouble();
		
		return result;
	}
}