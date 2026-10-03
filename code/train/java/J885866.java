import java.util.Scanner;

public class Main{
	static int[] fact = new int[10];
	static int[] sum = new int[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String	str = sc.next();
		long[] num = new long[str.length()];

		for(int i=0; i<str.length(); i++){
			num[i] = str.charAt(i) - '0';
		}

		Factrial();

		int bfr = 0, aft = str.length()-1;
		long ans = 0;
		while(aft>-1){
			for(int i=aft; i>=0; i--){
				ans += num[bfr]*fact[(i>0)?i-1:0]*fact[bfr];
				num[bfr] *= 10;
			}
			bfr++;
			aft--;
		}

		System.out.println(ans);
	}

	public static void Factrial(){
		fact[0] = 1;
		sum[0] = fact[0];
		for(int i=1; i<10; i++){
			fact[i] = fact[i-1]*2;
			sum[i] = sum[i-1]+fact[i];
		}
	}
}