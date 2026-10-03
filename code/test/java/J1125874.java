import java.util.*;

public class Main {
	private static String w;
	private static void input() {
		Scanner sc = new Scanner(System.in);
		w = sc.next();
	}

	public static void main(String[] args) {
		input();
		char[] alphabet = new char[26];
		String str = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < 26; i++)
			alphabet[i] = str.charAt(i);
		int[] counter = new int[26];
		for(int i = 0; i < w.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(w.charAt(i) == alphabet[j])
					counter[j]++;
			}
		}
		boolean beautiful = true;
		for(int i = 0; i < 26; i++)
			beautiful = beautiful && (counter[i]%2 == 0);
		System.out.println(beautiful ? "Yes" : "No");
	}
}