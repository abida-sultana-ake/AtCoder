import java.util.Scanner;
 
public class Main{
	
	static final Scanner s=new Scanner(System.in);
	
	public static void main(String[] __){
		String a=s.next(),b=s.next();
		
		if(a.equals(b)) {
			System.out.println("EQUAL");
			return;
		}
		
		int l=a.length()-b.length();
		
		if(l>0) {
			System.out.println("GREATER");
			return;
		}
		if(l<0) {
			System.out.println("LESS");
			return;
		}
		
		System.out.println(a.compareTo(b)>0?"GREATER":"LESS");
	}
}