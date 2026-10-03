import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String op = sc.next();
        int B = sc.nextInt();
        if(op.equals("+")) System.out.println(A + B);
        else if(op.equals("-")) System.out.println(A - B);
	}

}