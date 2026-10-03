import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		// スペース区切りの整数の入力
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int c  ;
		c = a % 3 ;
        if(c == 0){
			// 出力
			System.out.println("Possible");
			return;
        }

		c = b % 3 ;
        if(c == 0){
			// 出力
			System.out.println("Possible");
			return;
        }

		c = (a + b) % 3 ;
        if(c == 0){
			// 出力
			System.out.println("Possible");
			return;
        }

		System.out.println("Impossible");

	}
}
