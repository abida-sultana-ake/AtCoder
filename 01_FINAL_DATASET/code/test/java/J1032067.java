import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int t[]=new int[n];
		int sum=0;
		for (int i = 0; i < n; i++) {
			t[i]=sc.nextInt();
			sum+=t[i];
}
		int m=sc.nextInt();
		int p[]=new int[m];
		int x[]=new int[m];
		for (int i = 0; i < m; i++) {
			p[i]=sc.nextInt()-1;
			x[i]=sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			System.out.println(sum-t[p[i]]+x[i]);
		}	
		
	}

}