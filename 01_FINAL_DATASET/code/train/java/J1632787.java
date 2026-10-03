import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dfs(0, N, "");
		return;
	}
	
	public static void dfs(int c, int max, String acc) {
		char[] cl = {'a', 'b', 'c'};
		if(c==max) {
			System.out.println(acc);
			return;
		}
		for(int i=0; i<cl.length; i++) {
			String newstr = acc + cl[i];
			dfs(c+1, max, newstr);
		}
	}

}
