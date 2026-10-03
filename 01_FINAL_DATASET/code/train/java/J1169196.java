import java.util.Scanner;

public class Main {
	private static Scanner sc=new Scanner(System.in);
	private static int x=sc.nextInt();
	private static final int I_MAX=100000;
	public static void main(String[] args){
		int i;
		for(i=1;i<I_MAX;i++){
			if(i*(i+1)/2>=x) break;
		}
		System.out.println(i);
	}
}