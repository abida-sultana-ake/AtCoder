import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int x = 0;
		int y = 0;
		int s1,s2,s3 = 0;
		int ans = 0;
		if(W % 3 == 0 || H % 3 == 0){
			System.out.println(0);
			return;
		} else{
			x = W/3;
			y = H/2; 
			s1 = x * H;
			s2 = (W - x) * y;
			s3 = (W - x) * (H-y);
			ans = maxmin(s1,s2,s3);
			x = W/3 + 1;
			y = H/2;
			s1 = x * H;
			s2 = (W - x) * y;
			s3 = (W - x) * (H-y);
			ans = Math.min(ans, maxmin(s1,s2,s3));
			x = H/3;
			y = W/2;
			s1 = x * W;
			s2 = (H - x) * y;
			s3 = (H - x) * (W-y);
			ans = Math.min(ans, maxmin(s1,s2,s3));
			x = H/3 + 1;
			y = W/2 ;
			s1 = x * W;
			s2 = (H - x) * y;
			s3 = (H - x) * (W-y);
			ans = Math.min(ans, maxmin(s1,s2,s3));
			ans = Math.min(ans, W);
			ans = Math.min(ans, H);
			System.out.println(ans);
		}	
	}
	
	static int maxmin(int a, int b , int c ){
		int max,min = 0;
		min = Math.min(a, b);
		min = Math.min(min, c);
		max = Math.max(a, b);
		max = Math.max(max, c);
		return max-min;		
	}
}
