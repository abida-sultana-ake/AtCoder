import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static String s;
	static String[] sw;
	static String first;
	static String second;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		s=sc.next();
		sw=new String[N];
		//0羊,1羊
		sw[0]="S"; first="S";
		sw[1]="S"; second="S";
		for(int i=1;i<N;i++){
			solve(i);
		}
		solve(0);
		if(first==sw[0] && second==sw[1]){
			for(int i=0;i<N;i++){
				System.out.print(sw[i]);
			}
			return;
		}
		Arrays.fill(sw, null);
		//0羊、1狼
		sw[0]="S"; first="S";
		sw[1]="W"; second="W";
		for(int i=1;i<N;i++){
			solve(i);
		}
		solve(0);
		if(first==sw[0] && second==sw[1]){
			for(int i=0;i<N;i++){
				System.out.print(sw[i]);
			}
			return;
		}
		Arrays.fill(sw, null);
		//0狼、1羊
		sw[0]="W"; first="W";
		sw[1]="S"; second="S";
		for(int i=1;i<N;i++){
			solve(i);
		}
		solve(0);
		if(first==sw[0] && second==sw[1]){
			for(int i=0;i<N;i++){
				System.out.print(sw[i]);
			}
			return;
		}
		Arrays.fill(sw, null);
		//0狼、1狼
		sw[0]="W"; first="W";
		sw[1]="W"; second="W";
		for(int i=1;i<N;i++){
			solve(i);
		}
		solve(0);
		if(first==sw[0] && second==sw[1]){
			for(int i=0;i<N;i++){
				System.out.print(sw[i]);
			}
			return;
		}
		
		System.out.println(-1);
	}
	static void solve(int i){
		if((sw[i]=="S" && s.charAt(i)=='o')||(sw[i]=="W" && s.charAt(i)=='x')){
			if(i==N-1)sw[0]=sw[N-2];
			else if(i==0)sw[1]=sw[N-1];
			else sw[i+1]=sw[i-1];
		}else{
			if(i==N-1){
				if(sw[N-2]=="S")sw[0]="W";
				else sw[0]="S";
			}else if(i==0){					
				if(sw[N-1]=="S")sw[1]="W";
				else sw[1]="S";
			}else{
				if(sw[i-1]=="S")sw[i+1]="W";
				else sw[i+1]="S";
			}
		}
	}
}
