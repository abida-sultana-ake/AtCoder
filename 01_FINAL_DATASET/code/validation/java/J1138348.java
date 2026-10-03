
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner key = new Scanner(System.in);
		int n = key.nextInt();

		if(n%2 == 0){
			System.out.println(n-1);
		}else{
			System.out.println(n+1);
		}
	}
}