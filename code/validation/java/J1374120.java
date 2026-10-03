import java.util.Scanner;
import java.util.stream.IntStream;

public class Main{
	private static final int mod=1000000007;
	static final Scanner s=new Scanner(System.in);
	static IntStream REPS(int v){
		return IntStream.range(0,v);
	}
	static IntStream REPS(int l,int r){
		return IntStream.rangeClosed(l,r);
	}
	static IntStream INS(int n){
		return REPS(n).map(i->getInt());
	}
	static int getInt(){
		return Integer.parseInt(s.next());
	}
	public static void main(String[]__){
		int d=getInt(),m=getInt();
		
		if(Math.abs(d-m)>=2) {
			System.out.println(0);
			return;
		}
		
		
		long r=1;
		
		for(int i=1;i<=d;i++) {
			r*=i;
			r%=mod;
		}
		for(int i=1;i<=m;i++) {
			r*=i;
			r%=mod;
		}
		
		System.out.println(d==m?r*2%mod:r);
	}
}
