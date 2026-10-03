import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		// スペース区切りの整数の入力
		int b = sc.nextInt();
		
		int BsA = b/a;
		float BsARest = b%a;
		if(BsARest > 0){
			BsA++;
		}
		
		// 出力
		System.out.println(BsA);
	}
}
