import java.util.*;
public class Main {
	static Scanner s = new Scanner(System.in);
	public static void main(String __[]){
		input();
		solve();
	}

	static int n,imos[];
	private static void input() {
		n=s.nextInt();
		imos=new int[1145140];
	}
	private static void solve(){
		for(int l=0;l<n;l++) {
			imos[s.nextInt()]++;
			imos[s.nextInt()+1]--;
		}
		Arrays.parallelPrefix(imos, (a,b)->a+b);
		System.out.println(Arrays.stream(imos).parallel().max().getAsInt());
	}
}
