import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	static int N,W;
	static int w0;
	static ArrayList<Integer>[] v=new ArrayList[4];
	
	static void solve(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		
		for (int i = 0; i < v.length; i++) {
			v[i]=new ArrayList<Integer>(N);
		}
		w0=sc.nextInt();
		v[0].add(sc.nextInt());
		
		for(int i=1;i<N;i++){
			int w=sc.nextInt();
			v[w-w0].add(sc.nextInt());
		}
		for(int i=0;i<v.length;i++){
			v[i].sort(Comparator.reverseOrder());
		}
		
		System.out.println(solve2(0,N,0));
	}
	static int solve2(int startIndex,int numLeft,int totalW){
		
		if(startIndex>=v.length){
			return 0;
		}
		
		int vi=0;
		int wi=totalW;
		int max_v=0;
		
		for(int n=0;n<=numLeft && n<=v[startIndex].size();n++){
			if(n>=1){
				vi+=v[startIndex].get(n-1);
				wi+=w0+startIndex;
			}
			if(wi>W)break;
			
			max_v=Integer.max(max_v, vi+solve2(startIndex+1,numLeft-n,wi));
		}
		return max_v;
	}
}
