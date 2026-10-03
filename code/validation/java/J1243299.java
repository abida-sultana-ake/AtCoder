import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);



	public static void main(String[] args) {
		final int mod=1000000007;
		int w=s.nextInt()-1,h=s.nextInt()-1;
		if(w<h) {
			int buf=h;
			h=w;
			w=buf;
		}
		long res=1;
		for(int i=1;i<=h;i++) {
			res*=w+i;
			res%=mod;
		}
		for(int i=h;i>1;i--) {
			res*=modPow(i, mod-2, mod);
			res%=mod;
		}
		System.out.println(res);
	}

	static int j=0;
	public static final long modPow(long n,long p,long mod) {
		if(p==0) return 1;
		if(p==1) return n%mod;
		if(p%2==0) {
			long buf=modPow(n, p/2, mod);
			return buf*buf%mod;
		}
 		return n*modPow(n, p-1, mod)%mod;
	}
}
