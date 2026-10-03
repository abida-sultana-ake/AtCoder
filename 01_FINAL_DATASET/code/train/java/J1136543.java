import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int l = sc.nextInt();
		int r = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0;i < l;i++) {
			int t = sc.nextInt();
			if (map.containsKey(t)) {
				map.put(t,map.get(t)+1);
			} else {
				map.put(t,1);
			}
		}

		int ret = 0;
		for (int i = 0;i < r;i++) {
			int t = sc.nextInt();
			if (map.containsKey(t)&&map.get(t)>0) {
				map.put(t,map.get(t)-1);
				ret++;
			}
		}

		System.out.println(ret);
	}
}