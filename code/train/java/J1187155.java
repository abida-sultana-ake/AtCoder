import java.util.Scanner;

public class Main {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		double A =sc.nextInt();
		double B =sc.nextInt();
		double C =sc.nextInt();
		double D =sc.nextInt();
		A=B/A;
		C=D/C;
		if(A>C)System.out.println("TAKAHASHI");
		if(A<C)System.out.println("AOKI");
		if(A==C)System.out.println("DRAW");
	}

}
