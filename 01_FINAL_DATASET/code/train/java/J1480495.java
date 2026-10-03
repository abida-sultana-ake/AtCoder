import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int i=0;
		while(true){
			if((1<<(i+1))<=N)i++;
			else break;
		}
		System.out.println(1<<i);
	}

}
