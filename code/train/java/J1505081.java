import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int start = (A>C)?A:C;
		int end = (B<D)?B:D;
		System.out.println((end-start>0)?(end-start):0);
	}

}
