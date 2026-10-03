import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt(); // 周長
		int x = sc.nextInt(); // 動く歩道の速度
		int y = sc.nextInt(); // 高橋の速度
		int s = sc.nextInt(); // 高橋の初期位置
		int d = sc.nextInt(); // 出口

		double ft = forwardTime(l, x, y, s, d);
		double bt = backwardTime(l, x, y, s, d);

		double ans;
		if(s == d) ans = 0;
		else if(bt < 0 ) ans = ft;
		else ans = ft < bt ? ft : bt;

		System.out.println(ans);

		sc.close();
	}

	static double forwardTime(int l, int x, int y, int s, int d){
		int dist = (d - s) > 0 ? d - s : (d + l) - s;
		return (double)dist / (x + y);
	}
	static double backwardTime(int l, int x, int y, int s, int d){
		int dist = (s - d) < 0 ? d - (l + s) : d - s;
		return (double)dist / (x - y);
	}

}
