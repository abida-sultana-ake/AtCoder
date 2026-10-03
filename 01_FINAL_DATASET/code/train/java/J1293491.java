import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		double N=(double)scan.nextInt();
		double K=(double)scan.nextInt();

		double ans=(6*(N*K-K*K+K)-3*N-2)/(N*N*N);
		System.out.println(ans);

	}

}
