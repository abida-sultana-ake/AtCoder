import java.util.*;
 
// ABC 19-C
// http://abc019.contest.atcoder.jp/tasks/abc019_3
 
public class Main {

	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>(); 
		
		int counter = 0;
		
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			long xx = x;
			
			int groupNum = -1;
			while (xx >= 1) {
				if (map.containsKey(xx)) {
					groupNum = map.get(xx);
					break;
				} else if (xx % 2 == 0) {
					xx /= 2;
				} else {
					break;
				}
			}
			
			int inserting = groupNum == -1 ? counter : groupNum;
//			System.out.printf("x: %d, xx: %d, inserting: %d\n", x, xx, inserting);
			while (xx <= x) {
				map.put(xx, inserting);
				xx *= 2;
			}
			if (groupNum == -1) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}	
	
	public static int groupValue(HashMap<Integer, Integer> map, int x) {
		if (map.containsKey(x)) {
			return map.get(x);
		} else if (x == 1) {
			return -1; 
		} else if (x % 2 == 0) {
			return groupValue(map, x / 2);
		} else {
			return -1;
		}
	}
}
