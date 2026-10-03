import java.util.*;

// ABC 18-C
// http://abc018.contest.atcoder.jp/tasks/abc018_3
 
public class Main {

	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		int h = in.nextInt();
		int w = in.nextInt();

		long answer = Long.MAX_VALUE;

		// Divide vertically
		int dividedBy3 = w / 3;
		if (w % 3 == 0) {
			answer = 0;
		} else {
			answer = Math.min(answer, h);
		}

		// Divide vertically
		dividedBy3 = h / 3;
		if (h % 3 == 0) {
			answer = 0;
		} else {
			answer = Math.min(answer, w);
		}
		
		// Divide vertically first and divide horizontally in the first column
		long half = w / 2;
		for (long i = 1; i < h; i++) {
			long max = Math.max(Math.max(half * i, (w - half) * i), w * (h - i));
			long min = Math.min(Math.min(half * i, (w - half) * i), w * (h - i));
			answer = Math.min(answer, max - min);
		}
		
		// Divide horizontally first and divide vertically in the first row
		half = h / 2;
		for (long i = 1; i < w; i++) {
			long max = Math.max(Math.max(half * i, (h - half) * i), (w - i) * h);
			long min = Math.min(Math.min(half * i, (h - half) * i), (w - i) * h);
			
			answer = Math.min(answer, max - min);
		}
		
		System.out.println(answer);
	}
}