import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int txa, tya, txb, tyb, T, V, n;
		Scanner sc = new Scanner(System.in);
		txa = sc.nextInt();
		tya = sc.nextInt();
		txb = sc.nextInt();
		tyb = sc.nextInt();
		T = sc.nextInt();
		V = sc.nextInt();
		n = sc.nextInt();
		int x, y;
		int flag = 0;
		for(int i=0; i<n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			if(dist(x, y, txa, tya) + dist(x, y, txb, tyb) <= T*V) {
				flag = 1;
			}
		}
		if(flag == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		return;
	}
	
	private static double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}

}