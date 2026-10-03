import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
//		Interval[] intervals = new Interval[N];
//		for(int i=0; i<N; i++) {
//			int l = sc.nextInt();
//			int r = sc.nextInt();
//			int s = sc.nextInt();
//			intervals[i] = new Interval(l, r, s);
//		}
//		long max = 0;
//		for(int i=1; i<=M; i++) {
//			long tempmax = 0;
//			for(int j=0; j<N; j++) {
//				if(intervals[j].contains(i)) {
//					;
//				} else {
//					tempmax += intervals[j].score;
//				}
//			}
//			if(tempmax > max) {
//				max = tempmax;
//			}
//		}
//		System.out.println(max);
		// imos
		long[] imos = new long[M+2];
		long sum = 0;
		for(int i=0; i<N; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			imos[l] += s;
			imos[r+1] -= s;
			sum += s;
		}
		sc.close();
		long min = imos[1];
		for(int i=2; i<=M; i++) {
			imos[i] += imos[i-1];
			if(min > imos[i]) {
				min = imos[i];
			}
		}
		System.out.println(sum-min);
	}
//	
//	private static class Interval {
//		int l, r, score;
//		Interval(int l, int r, int s) {
//			this.l = l;
//			this.r = r;
//			this.score = s;
//		}
//		public boolean contains(int x) {
//			if(l<= x && x <= r) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//	}

}
