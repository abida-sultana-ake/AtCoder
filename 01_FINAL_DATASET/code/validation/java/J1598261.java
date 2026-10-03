import java.util.Scanner;
import java.util.stream.IntStream;

public class Main{
	static IntStream REPS(int v){return IntStream.range(0,v);}
	static IntStream REPS(int l,int r){return IntStream.rangeClosed(l,r);}
	static IntStream INS(int n) {return REPS(n).map(i->getInt());}
	static Scanner s=new Scanner(System.in);
	static int getInt(){return Integer.parseInt(s.next());}

	public static void main(String[]$){
		int n=getInt();
		int[][]f=REPS(n).mapToObj(o->INS(n).toArray()).toArray(int[][]::new);

		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(f[i][j]>f[i][k]+f[j][k]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		long sum=0;
		for(int i=0;i<n;++i)
			for(int j=0;j<n;++j)
				sum+=f[i][j];

		//System.out.println(sum);

		for(int i=0;i<n;++i){
			for(int j=0;j<n;++j)if(i!=j){
				for(int k=0;k<n;++k)if(i!=k&&j!=k){
					//System.out.println(i+" "+j+" "+k);
					if(f[i][j]==f[i][k]+f[j][k]) {
					//	System.out.println(i+" "+j+" "+k);
						sum-=f[i][j];
//						System.out.println(-1);
						break;
					}
				}
			}
		}
		System.out.println(sum/2);
	}
}