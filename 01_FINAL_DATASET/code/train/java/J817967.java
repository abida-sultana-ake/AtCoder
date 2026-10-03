import java.util.Scanner;
 
public class Main{
	static int mod=1000000007;
	static long[] fact=new long[500001];
	static long[] rev=new long[500001];
	static long pow(long a,long x,long m){
		if(x==0) return 1;
		else if(x%2==0) return pow((a*a)%m,x/2,m)%m;
		else return (a*pow((a*a)%m,x/2,m))%m;
	}
	static long rev(long a,long mod){
		if(a%mod==0) return 0;
		return pow(a,mod-2,mod)%mod;
	}
	static long ncr(long n,long r){
		long res=1;
		if(n==0 || r==0 || n==r) return res;
		res*=fact[(int)n]; res%=mod;
		res*=rev[(int)r]; res%=mod;
		res*=rev[(int)(n-r)]; res%=mod;
		return res;
	}
	static void init(){
		fact[1]=1; rev[1]=1;
		for(long i=2;i<fact.length;i++){
			fact[(int)i]=i*fact[(int)(i-1)]; fact[(int)i]%=mod;
			rev[(int)i]=rev(fact[(int)i],mod);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		init();
		while(sc.hasNext()){
			long h=sc.nextLong(),w=sc.nextLong(),a=sc.nextLong(),b=sc.nextLong();
			long ans=0;
			for(long i=1;i<=h-a;i++){
				ans+=(ncr(b+i-2,i-1)*ncr(w-b-1+h-i,h-i))%mod;
				ans%=mod;
			}
			System.out.println(ans);
		}
	}
}