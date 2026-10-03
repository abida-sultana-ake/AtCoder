/**
 * DA-IICT
 * Author : Savaliya Sagar
 */
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;

class Main
{
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int a = ni();
		int b = ni();
		int c = ni();
		int d = ni();
		int e = ni();
		int f = ni();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i=0;c*i<=f;i++){
			for(int j=0;c*i+d*j<=f;j++){
				ts.add(c*i+d*j);
			}
		}
		double max = 0;
		int t = 0;
		int s = 0;
		for(int i=0;i*100*a<=f;i++){
			for(int j=0;j*100*b + i*100*a<=f;j++){
				int w = j*100*b + i*100*a;
				double ns = (w*e)/100.0;
				if(ns+w>f){
					ns = f - w;
				}
				int gs = ts.floor((int)ns);
				if((gs*1.0)/(gs+w)>=max){
					max = (gs*1.0)/(gs+w);
					t = gs+w;
					s = gs;
				}
			}
		}
		out.println(t + " " + s);
	}
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}
	
	public static void main(String[] args) throws Exception
	{
		new Thread(null, new Runnable()
		{
			public void run()
			{
				try
				{
					new Main().run();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}, "1", 1 << 26).start();
	}
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf)
		{
			ptrbuf = 0;
			try
			{
				lenbuf = is.read(inbuf);
			} catch (IOException e)
			{
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c)
	{
		return !(c >= 33 && c <= 126);
	}
	
	private int skip()
	{
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}
	
	private double nd()
	{
		return Double.parseDouble(ns());
	}
	
	private char nc()
	{
		return (char) skip();
	}
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b)))
		{ // when nextLine, (isSpaceChar(b) && b !=
				// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b)))
		{
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-')
		{
			minus = true;
			b = readByte();
		}
		
		while (true)
		{
			if (b >= '0' && b <= '9')
			{
				num = num * 10 + (b - '0');
			} else
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-')
		{
			minus = true;
			b = readByte();
		}
		
		while (true)
		{
			if (b >= '0' && b <= '9')
			{
				num = num * 10 + (b - '0');
			} else
			{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private void tr(Object... o)
	{
		System.out.println(Arrays.deepToString(o));
	}
}
