import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 1;
		while(ans * 2 <= N){
			ans *= 2;
		}
		System.out.println(ans);
	}

}

