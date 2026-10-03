import java.util.*;
public class Main {
	static final Scanner s = new Scanner(System.in);

	static int n;
	static char[] c;
	public static void main(String args[]){
		n=s.nextInt();
		c=new char[n];
		f(0);
	}
	static void f(int depth) {
		if(depth==n) {
			System.out.println(String.valueOf(c));
			return;
		}
		c[depth]='a';
		f(depth+1);
		c[depth]='b';
		f(depth+1);
		c[depth]='c';
		f(depth+1);
	}
}
