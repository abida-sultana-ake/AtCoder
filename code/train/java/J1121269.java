import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int D = sc.nextInt();
		if((A + 1)*D < (D + 1)*A){
			System.out.println((D + 1)*A);
		}
		else{
			System.out.println((A + 1)*D);
		}
	}

}
