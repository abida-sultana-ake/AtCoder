import java.util.Scanner;


public class Main{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(surfaceArea(a, b, c));
		
		sc.close();
	}
	
	static int surfaceArea(int a, int b, int c){
		return a * b * 2 + b * c * 2 + c * a * 2;
	}
}
