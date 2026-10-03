import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int total = A + B;
		if(total >= 10) {
			System.out.println("error");
		}else {
			System.out.println(total);
		}
	}

}
