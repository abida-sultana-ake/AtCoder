import java.util.Scanner;

public class Main {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		String S = sc.next();
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int E = 0;
		int F = 0;
		for(int i=0;i<S.length();i++){
			char s = S.charAt(i);
			if(s=='A'){
				A=A+1;
			}
			else if(s=='B'){
				B=B+1;
			}
			else if(s=='C'){
				C=C+1;
			}
			else if(s=='D'){
				D=D+1;
			}
			else if(s=='E'){
				E=E+1;
			}
			if(s=='F'){
				F=F+1;
			}
			
		}
		System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+F);
	}

}
