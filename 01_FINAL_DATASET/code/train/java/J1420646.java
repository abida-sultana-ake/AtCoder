import java.util.Scanner;

/**
 * http://abc001.contest.atcoder.jp/tasks/abc001_3
 */
public class Main {
	
	final static String DIR[] = {"N","NNE","NE","ENE","E","ESE","SE","SSE",
			"S","SSW","SW","WSW","W","WNW","NW","NNW"};
	final static double MAX_DIS[] = {0.2, 1.5, 3.3, 5.4, 7.9, 10.7, 13.8, 17.1,
			20.7, 24.4, 28.4, 32.6};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int deg = sc.nextInt();
		double dis = sc.nextDouble();
		sc.close();
		
		int w = 0;
		dis = ((double)Math.round(dis/6))/10;
		while(dis>MAX_DIS[w]){
			w++;
			if(w==12) break;
		}
		String dir = w==0 ? "C" : DIR[((deg+112)/225)%16];
		
		System.out.println(String.format("%s %d", dir, w));

	}

}