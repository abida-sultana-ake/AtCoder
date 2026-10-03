import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int ans = solve();
		System.out.println(ans);
	}
	
	private static int solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> a = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (a.containsKey(x)) {
				a.put(x, a.get(x) + 1);
			} else {
				a.put(x, 1);
			}
		}
		
		int max = 0;
		
		for (int i : a.keySet()) {
			int tmp = 0;
			tmp += a.containsKey(i - 1)? a.get(i - 1) : 0;
			tmp += a.get(i);
			tmp += a.containsKey(i + 1)? a.get(i + 1) : 0;
			max = Math.max(max, tmp);
		}
		
		return max;
	}
}