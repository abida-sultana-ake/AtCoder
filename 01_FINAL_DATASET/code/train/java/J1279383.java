import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Main main = new Main();
		main.solveB();
	}

	private void solveB() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] num = new int[N + 1];
		for (int i = 0; i < M; i++) {
			num[sc.nextInt()]++;
			num[sc.nextInt()]++;
		}
		for (int j = 1; j <= N; j++) {
			System.out.println(num[j]);
		}
	}
}