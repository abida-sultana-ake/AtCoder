import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		String a = sc.next();
		char b = a.charAt(0);
		char c = a.charAt(1);

		String ans = "No";

		if(b=='9'|c=='9'){
			ans = "Yes";
		}

		// 出力
		System.out.println(ans);
	}
}
