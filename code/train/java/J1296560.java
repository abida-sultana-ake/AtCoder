import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		System.out.println(Math.min(solve(H,W), solve(W,H)));
		
		sc.close();
	}
	
	static long solve(long a, long b) {
		if(a%3==0) {
			return 0;
		} else {
			ArrayList<Long> div = div2(a-a/3, b);
			div.add(a/3*b);
			Collections.sort(div);
			long ans = div.get(2)-div.get(0);
			
			div = div2(a-a/3-1, b);
			div.add((a/3+1)*b);
			Collections.sort(div);
			ans = Math.min(ans, div.get(2)-div.get(0));
			return ans;
		}
	}
	
	static ArrayList<Long> div2(long a, long b) {
		ArrayList<Long> ans = new ArrayList<>();
		if(a%2==0 || b%2==0) {
			ans.add(a*b/2);
			ans.add(a*b/2);
		} else {
			if(a<b) {
				long temp = a;
				a = b;
				b = temp;
			}
			ans.add(a/2*b);
			ans.add((a-a/2)*b);
		}
		
		return ans;
	}
}
