import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		//入力
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		//出力
		System.out.println((a+b)%24);
	}

}
