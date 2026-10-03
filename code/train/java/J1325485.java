import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	int N;
	int[]s;
	int sum=0;
	void solve(){
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		s=new int[N];
		for(int i=0;i<N;i++){
			s[i]=sc.nextInt();
			sum+=s[i];
		}
		Arrays.sort(s);
		for(int i=0;i<N;i++){
			if(sum%10!=0){
				System.out.println(sum);
				return;
			}
			else if(s[i]%10!=0){
				sum-=s[i];
			}
		}
		System.out.println(0);
	}
}
