
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Main{
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";


	public static void main(String[] args) throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		solver();
		out.flush();
	}

	static long nl()
	{
		try {
			long num = 0;
			boolean minus = false;
			while((num = is.read()) != -1 && !((num >= '0' && num <= '9') || num == '-'));
			if(num == '-'){
				num = 0;
				minus = true;
			}else{
				num -= '0';
			}

			while(true){
				int b = is.read();
				if(b >= '0' && b <= '9'){
					num = num * 10 + (b - '0');
				}else{
					return minus ? -num : num;
				}
			}
		} catch (IOException e) {
		}
		return -1;
	}

	static char nc()
	{
		try {
			int b = skip();
			if(b == -1)return 0;
			return (char)b;
		} catch (IOException e) {
		}
		return 0;
	}

	static double nd()
	{
		try {
			return Double.parseDouble(ns());
		}catch(Exception e) {
		}
		return 0;
	}

	static String ns()
	{
		try{
			int b = skip();
			StringBuilder sb = new StringBuilder();
			if(b == -1)return "";
			sb.append((char)b);
			while(true){
				b = is.read();
				if(b == -1)return sb.toString();
				if(b <= ' ')return sb.toString();
				sb.append((char)b);
			}
		} catch (IOException e) {
		}
		return "";
	}

	public static char[] ns(int n)
	{
		char[] buf = new char[n];
		try{
			int b = skip(), p = 0;
			if(b == -1)return null;
			buf[p++] = (char)b;
			while(p < n){
				b = is.read();
				if(b == -1 || b <= ' ')break;
				buf[p++] = (char)b;
			}
			return Arrays.copyOf(buf, p);
		} catch (IOException e) {
		}
		return null;
	}

	public static byte[] nse(int n)
	{
		byte[] buf = new byte[n];
		try{
			int b = skip();
			if(b == -1)return null;
			is.read(buf);
			return buf;
		} catch (IOException e) {
		}
		return null;
	}

	static int skip() throws IOException
	{
		int b;
		while((b = is.read()) != -1 && !(b >= 33 && b <= 126));
		return b;
	}

	static boolean eof()
	{
		try {
			is.mark(1000);
			int b = skip();
			is.reset();
			return b == -1;
		} catch (IOException e) {
			return true;
		}
	}

	static int ni()
	{
		try {
			int num = 0;
			boolean minus = false;
			while((num = is.read()) != -1 && !((num >= '0' && num <= '9') || num == '-'));
			if(num == '-'){
				num = 0;
				minus = true;
			}else{
				num -= '0';
			}

			while(true){
				int b = is.read();
				if(b >= '0' && b <= '9'){
					num = num * 10 + (b - '0');
				}else{
					return minus ? -num : num;
				}
			}
		} catch (IOException e) {
		}
		return -1;
	}


	static void solver() {
		Scanner sc = new Scanner(System.in);
		int n = ni();
		int k = ni();
		int[] d = new int[k];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < k; i++) {
			d[i] = ni();
			set.add(d[i]);
		}
		while (true) {
			int tmp = n;
			while (tmp >= 1) {
				if (set.contains(tmp % 10)) {
					break;
				}
				tmp /= 10;
			}
			if (tmp == 0) {
				out.println(n);
				return;
			}
			n++;
		}
	}
}
