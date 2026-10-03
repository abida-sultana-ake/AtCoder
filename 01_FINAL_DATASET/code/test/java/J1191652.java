import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		
		if((a+b+c)/2==a+b||
		   (a+b+c)/2==a+c||
		   (a+b+c)/2==b+c)System.out.print("Yes");
		else System.out.print("No");

	}

}
