import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n > 12) {
			n = n - 12;
		}
		double tanshin = n * 30 + m * 0.5;
		double choushin = m * 6;
		double degree = Math.abs(tanshin - choushin);
		if(degree > 180) {
			degree = 360 - degree;
		}
		System.out.println(degree);
	}
}//60min:360/12=30,1min:0.5度
//60min:1min:6度