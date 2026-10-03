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
	int A = in.nextInt();
	int max = 0;
	for(int i=0;i<=A;i++){
	    if(i*(A-i)>max) max = i*(A-i);
	}
	out.println(max);
    }
}
