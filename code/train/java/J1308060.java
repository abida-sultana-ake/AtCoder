import java.util.*;

public class Main {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		Main soln = new Main();
		System.out.println((soln.jdg(a,b,c))? "YES":"NO");
	}

	private boolean jdg(int a, int b, int c) {
		if(c==0) return true;
		if(a==100) return false;
		int end = 101;
		for(int i=0; i<end; i++) {
			if((b*i+c)%a==0) return true;
		}
		return false;
	}
}