import java.util.*;
public class Main {
	static Scanner s = new Scanner(System.in);
	public static void main(String __[]){
		/*
		for(int i=0;i<=23;i++)
			for(int j=0;j<=59;j++) {
				System.out.printf("%02d:%02d----------\n",i,j);
				solve(i, j);
			}
		/**/
		solve(s.nextInt(),s.nextInt());
	}
	private static void solve(int a,int b){
		a%=12;
		final double v=Math.abs(
				(360*a/12.0+30*b/60.0)
				-(360*b/60.0));
		System.out.printf("%.6f\n",
				Math.min(360-v, v)
				);
	}
}
