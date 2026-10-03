
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		abc012_1(n);
	}
	
	static void abc012_1(int n) {
		int rest = 2025 - n;
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(rest == i * j) {
					System.out.print(i);
					System.out.print(" x ");
					System.out.println(j);
				}
			}
		}
	}
}