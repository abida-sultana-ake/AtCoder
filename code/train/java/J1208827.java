import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
public class Main {
	public static void main(String[] args){
		Main main = new Main();
		main.solveC();
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
}