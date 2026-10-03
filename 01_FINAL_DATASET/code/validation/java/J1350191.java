import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	int W,H;
	int mod=1000000000+7;
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		W=sc.nextInt();
		H=sc.nextInt();
		//(W+H-2)!/((W-1)!*(H-1)!)を求める
		
		long ans=1;
	
		for(int i=1;i<=H+W-2;i++){
			ans*=i;
			ans%=mod;
		}
		
		for(int i=1;i<W;i++){
			ans*=calc(i,mod-2,mod);
			ans%=mod;
		}
		
		for(int i=1;i<H;i++){
			ans*=calc(i,mod-2,mod);
			ans%=mod;
		}
		
		System.out.println(ans);
	}
	
	//a^b(mod p)
	long calc(int a,int b,int p){
		if(b==0)return 1;
		else if(b%2==0){
			long d=calc(a,b/2,p);
			return (d*d)%p;
		}else{
			return (a*calc(a,b-1,p))%p;
		}
	}
}
