import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner	sc = new Scanner(System.in);
		String W = sc.next();
		
		W=W.replaceAll("a", "");
		W=W.replaceAll("i", "");
		W=W.replaceAll("u", "");
		W=W.replaceAll("e", "");
		W=W.replaceAll("o", "");
		
		System.out.println(W);
		


	}

}
