import java.util.*;

public class Main {
	static final Scanner s = new Scanner(System.in);
	static int n,m;
	static boolean graph[][],checked[];
	public static void main(String args[]){
		n=s.nextInt();
		m=s.nextInt();
		graph = new boolean[n][n];
		checked = new boolean[n];
		for(int i=0;i<m;i++) {
			byte a=s.nextByte(),b=s.nextByte();
			graph[--a][--b]=true;
			graph[b][a]=true;
		}
		int max=-114514;
		for(int i=0;i<n;i++) {
			max=Math.max(max,check(i, 1));
		}
		System.out.println(max);
	}
	static int check(int i, int depth){
		for(int l=0;l<n;l++) {
			if(checked[l]&&!graph[l][i])
				return 0;
		}
		checked[i]=true;
		int m=depth;
		for(int l=i;l<n;l++)
			m=Math.max(m,check(l, depth+1));
		checked[i]=false;
		return m;
	}
}