import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		int N =scan.nextInt();
		int K=scan.nextInt();
		int[] R = new int[N];

		BigDecimal C=BigDecimal.valueOf(0);
		BigDecimal ad;

		for(int i=0;i<N;i++){
			R[i]=scan.nextInt();
		}
		Arrays.sort(R);

		for(int i=0;i<K;i++){
			ad = BigDecimal.valueOf(R[N-1-i]);
//			System.out.println(ad.intValue());
			for(int j=0;j<i+1;j++){
				ad = ad.divide(BigDecimal.valueOf(2), 8, BigDecimal.ROUND_HALF_UP);
//				System.out.println(ad.doubleValue());
			}
			C=C.add(ad);
		}

		System.out.println(C.doubleValue());


	}

}
