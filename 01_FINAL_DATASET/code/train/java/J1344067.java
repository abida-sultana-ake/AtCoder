import java.util.Scanner;

public class Main {
	static int N;
	static long A,B;
	static Long[] h;

	public static void main(String[] args){
		Scanner io = new Scanner(System.in);
		int N = io.nextInt();
		String S = io.next();
		int len = S.length();
		int stack = 0;
		for (int i = len-1; i>=0; i--) {
			if(S.charAt(i)==')') stack ++;
			else if(S.charAt(i)=='('){
				if(stack>0) stack --;
				else S = S + ")";
			}
		}
		for(int i=0;i<stack;i++){
			S = "(" + S;
		}
		System.out.println(S);
	}	
}