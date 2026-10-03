import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	
		Scanner scan = new Scanner(System.in);

		
		int x = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int sum = Math.abs(x - a);
		int ave = Math.abs(x - b);
		
		if(sum < ave) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
		
		
		/*for(int i = 0; i <= A; i++) {
			for(int j = 0; j < A; j++) {
				System.out.print("☆");
				
			}
			System.out.println("");
		}*/
		
	}

}
