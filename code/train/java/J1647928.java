
import java.util.Scanner;

public class Main {

	void	 solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), d = in.nextInt(), k = in.nextInt();
		int[] l = new int[d], r = new int[d];
		City[] cities = new City[k];
		for(int i = 0; i < d; i++) {
			l[i] = in.nextInt();
			r[i] = in.nextInt();
		}
		for(int i = 0; i < k; i++) {
			cities[i] = new City(in.nextInt(), in.nextInt());
		}
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < k; j++) {
				if(cities[j].pos != cities[j].to) {
					cities[j].ans++;
				}
				if(l[i] <= cities[j].pos && cities[j].pos <= r[i] && cities[j].pos != cities[j].to) {
					if(l[i] <= cities[j].to && cities[j].to <= r[i]) {
						cities[j].pos = cities[j].to;
					}else if(cities[j].to <= l[i]) {
						cities[j].pos = l[i];
					}else {
						cities[j].pos = r[i];
					}
				}
			}
		}
		for(int i = 0; i < k; i++) {
			System.out.println(cities[i].ans);
		}
	}
	public static void main(String[] args) throws Exception{
		new Main().solve();
	}
}

class City{
	int pos, to, ans;
	public City(int p, int t) {
		pos = p;
		to = t;
		ans = 0;
	}
}