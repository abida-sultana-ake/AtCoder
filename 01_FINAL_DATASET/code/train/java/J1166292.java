import java.util.Scanner;

public class Main {
	private static Scanner sc=new Scanner(System.in);
	private static final int N_MAX=40;
	private static final int AB_MAX=10;
	private static final int INF=1000000;
	private static int[] a=new int[N_MAX];
	private static int[] b=new int[N_MAX];
	private static int[] c=new int[N_MAX];
	private static int[][][] dp=new int[N_MAX+1][N_MAX*AB_MAX+1][N_MAX*AB_MAX+1];
	public static void main(String[] args){
		int n,ma,mb;
		n=sc.nextInt();
		ma=sc.nextInt();
		mb=sc.nextInt();
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
			c[i]=sc.nextInt();		
		}
		for(int i=0;i<=n;i++){
			for(int ca=0;ca<=N_MAX*AB_MAX;ca++){
				for(int cb=0;cb<=N_MAX*AB_MAX;cb++){
					dp[i][ca][cb]=INF;
				}
			}
		}
		dp[0][0][0]=0;
		for(int i=0;i<n;i++){
			for(int ca=0;ca<=N_MAX*AB_MAX;ca++){
				for(int cb=0;cb<=N_MAX*AB_MAX;cb++){
					if(dp[i][ca][cb]==INF) continue;
					dp[i+1][ca][cb]=Math.min(dp[i][ca][cb],dp[i+1][ca][cb]);
					dp[i+1][ca+a[i]][cb+b[i]]=Math.min(dp[i+1][ca+a[i]][cb+b[i]], dp[i][ca][cb]+c[i]);
				}
			}
		}
		int ans=INF;
		for(int ca=1;ca<=N_MAX*AB_MAX;ca++){
			for(int cb=1;cb<=N_MAX*AB_MAX;cb++){
				if(ca*mb==cb*ma) ans=Math.min(ans,dp[n][ca][cb]);
			}
		}
		if(ans==INF) ans=-1;
		System.out.println(ans);
	}	
}