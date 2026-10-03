import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		System.out.println(S.charAt(0)+""+(S.length()-2)+""+S.charAt(S.length()-1));
	}

}
