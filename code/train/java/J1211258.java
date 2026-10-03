import java.math.BigInteger;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Main main = new Main();
		main.solveD();
	}

	private void solveA() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a - b == b - c) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private void solveB() {
		Scanner sc = new Scanner(System.in);
		String o = sc.nextLine();
		String e = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < e.length(); i++) {
			sb.append(o.charAt(i));
			sb.append(e.charAt(i));
		}
		if (o.length() != e.length()) {
			sb.append(o.charAt(o.length() - 1));
		}
		System.out.println(sb.toString());
	}

	private void solveC() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] min = new int[26];
		for (int i = 0; i < 26; i++) {
			min[i] = 51;
		}
		for (int i = 0; i < n; i++) {
			int[] tmp = new int[26];
			String buffer = sc.nextLine();
			for (int j = 0; j < buffer.length(); j++) {
				char asc = buffer.charAt(j);
				tmp[(asc - 'a')]++;
			}
			for (int j = 0; j < 26; j++) {
				if (min[j] > tmp[j]) {
					min[j] = tmp[j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < min[c - 'a']; i++) {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}

	private void solveD() {
		Scanner sc = new Scanner(System.in);
		BigInteger MOD = BigInteger.valueOf(1000000007);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//BigInteger prev = null;
		BigInteger sum_x = BigInteger.ZERO;
		/*
		for (int i = 0; i < n; i++) {
			BigInteger tmp = BigInteger.valueOf(sc.nextInt());
			if (prev != null) {
				sum_x = sum_x.add(tmp.subtract(prev).multiply(BigInteger.valueOf(i * (n - i))).remainder(MOD));
			}
			prev = tmp;
		}
		*/
		for (int i = 0; i < n; i++) {
			sum_x = sum_x.add(BigInteger.valueOf(sc.nextInt()).multiply(BigInteger.valueOf(2 * i - n + 1)));
		}
		//prev = null;
		BigInteger sum_y = BigInteger.ZERO;
		/*
		for (int i = 0; i < m; i++) {
			BigInteger tmp = BigInteger.valueOf(sc.nextInt());
			if (prev != null) {
				sum_y = sum_y.add(tmp.subtract(prev).multiply(BigInteger.valueOf(i * (m - i))).remainder(MOD));
			}
			prev = tmp;
		}
		*/
		for (int i = 0; i < m; i++) {
			sum_y = sum_y.add(BigInteger.valueOf(sc.nextInt()).multiply(BigInteger.valueOf(2 * i - m + 1)));
		}
		sum_x = sum_x.remainder(MOD);
		sum_y = sum_y.remainder(MOD);
		BigInteger ans = sum_x.multiply(sum_y).remainder(MOD);
		System.out.println(ans);
	}
}