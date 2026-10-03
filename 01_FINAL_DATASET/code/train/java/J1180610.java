import java.util.*;

public class Main {
	static final Scanner s = new Scanner(System.in);
	public static void main(String args[]){
		String i1=s.next(),i2=s.next();
		System.out.println(i1.length()>i2.length()?i1:i2);
	}
}
