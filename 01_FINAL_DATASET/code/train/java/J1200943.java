import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ARC004BSolve solve = new ARC004BSolve();
		solve.main();
	}
}

class ARC004BSolve {
	
	int N;
	int[] distances;
	
	ARC004BSolve() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.distances = new int[N];
		for (int i = 0; i < N; i++) {
			distances[i] = cin.nextInt();
		}
	}
	
	void main() {
		int sum = getSumDistance();
		
		// calculate min distance
		int maxDistance = 0;
		for (int distance : distances) {
			maxDistance = Math.max(maxDistance, distance);
		}
		int min = maxDistance - (sum - maxDistance);
		min = min < 0 ? 0 : min;
		System.out.println(sum);
		System.out.println(min);
	}
	
	int getSumDistance() {
		int max = 0;
		for (int distance : distances) {
			max += distance;
		}
		return max;
	}
	
}
