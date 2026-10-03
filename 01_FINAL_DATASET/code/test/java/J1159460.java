import java.util.Scanner;

class Main {
	public static void main (String[ ] args) {
		Scanner scanner = new Scanner (System.in);
		
		//入力
		int ret = scanner.nextInt( ) ;
		
		//出力
		if (ret % 2 == 0) {
			System.out.println("Blue");
		}else {
			System.out.println("Red");
		}
	}
}