import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	int n,k;
	int[]a;
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		
		//二分探索
		int max=n;
		int min=-1;
		int med=0;
		LOOP:while(max-min>1){
			med=(max+min)/2;
			
			if(a[med]>k){
				max=med;
				continue;
			}
			int idx=0;
			
			//dp[j][sum]:=j枚目までで和sumを作れるか
			boolean[][]dp=new boolean[n][k];
			for(int j=0;j<n;j++){
				dp[j][0]=true;
			}
			
			for(int j=1;j<n;j++){
				if(idx==med)idx++;	//i枚目は使わないので
				
				for(int sum=0;sum<k;sum++){
					if(dp[j-1][sum]){
						dp[j][sum]=true;
						int temp=sum+a[idx];
						if(temp<k)dp[j][temp]=true;
					}
				}
				idx++;
			}
			
			for(int sum=k-a[med];sum<k;sum++){
				if(dp[n-1][sum]){
					max=med;
					continue LOOP;
				}
			}
			min=med;
		}
		System.out.println(max);
	}
}