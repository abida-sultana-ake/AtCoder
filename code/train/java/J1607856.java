import java.util.*;

public class Main {
	static int INF = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
		m.put(1, new ArrayList<Integer>());
		for(int i=1; i<=N-1; i++) {
			int b = sc.nextInt();
			if(m.containsKey(b)) {
				ArrayList<Integer> tl = m.get(b);
				tl.add(i+1);
			} else {
				ArrayList<Integer> tl = new ArrayList<Integer>();
				tl.add(i+1);
				m.put(b, tl);
			}
		}
		int ans = getcost(1, m);
		System.out.println(ans);
	}
	
	public static int getcost(int c, HashMap<Integer, ArrayList<Integer>> m) {
		int max = 0;
		int min = INF;
		if(!m.containsKey(c)) {
			return 1;
		} else {
			for(int next: m.get(c)) {
				int temp = getcost(next, m);
				if(temp > max) {
					max = temp;
				}
				if(temp < min) {
					min = temp;
				}
			}
			return max + min + 1;
		}
	}

}