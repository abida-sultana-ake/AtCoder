import java.util.*;

public class Main {
	static final Scanner s = new Scanner(System.in);
	public static void main(String args[]){
		int a=s.nextInt(),b=s.nextInt();
		System.out.println(a%b==0?0:b-a%b);
	}
}
