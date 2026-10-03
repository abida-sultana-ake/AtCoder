import java.util.*;
import java.io.*;
     
public class Main{
    static PrintWriter out;
    static Scanner in;
    public static void main(String args[]){
	in = new Scanner(System.in);
	out = new PrintWriter(System.out);
	solve();
	in.close();
	out.close();
    }
     
    public static void solve(){
        int N = in.nextInt();
	String S = in.next();
	char[] C = S.toCharArray();
	int migi = 0;
	int migil = 0;
	int left = 0;
	int leftm = 0;
	for(int i=0;i<N;i++){
	    if(C[i]=='('){
		migil++;
	    }else if(C[i]==')'&&migil<=0){
		migi++;
	    }else if(C[i]==')'&&migil>0){
		migil--;
	    }

	    if(C[N-i-1]==')'){
		leftm++;
	    }else if(C[N-i-1]=='('&&leftm<=0){
		left++;
	    }else if(C[N-i-1]=='('&&leftm>0){
		leftm--;
	    }
	}
	for(int i=0;i<migi;i++)
	    out.print('(');
	for(int i=0;i<N;i++)
	    out.print(C[i]);
	for(int i=0;i<left;i++)
	    out.print(')');

	out.println();	    
    }
}
