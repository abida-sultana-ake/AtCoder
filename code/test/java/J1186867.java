import java.util.Scanner;

public class Main {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		int n =sc.nextInt();
		int k;
		for(int i=n;;i++){
			k=i;
			if(k%a==0&&k%b==0)break;
		}
		System.out.println(k);

	}

}
