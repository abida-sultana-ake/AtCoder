import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String c =sc.next();
        if(c.equals("a") ||c.equals("e") ||c.equals("i") ||
        		c.equals("o") ||c.equals("u")) {
        	System.out.println("vowel");
        }
        else System.out.println("consonant");
	}

}