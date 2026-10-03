import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n=s.nextInt();
		for(int i=n-1;i>1;i--) {
			if(n%i==0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
