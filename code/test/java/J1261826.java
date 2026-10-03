import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(y > x) {
			System.out.println("Better");
		}else {
			System.out.println("Worse");
		}
	}

}
