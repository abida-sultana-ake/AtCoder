import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		final int tXa = s.nextInt();
		final int tYa = s.nextInt();
		final int tXb = s.nextInt();
		final int tYb = s.nextInt();

		final int TIME = s.nextInt();
		final int SPEED = s.nextInt();

		final int NINZU = s.nextInt();
		Zahyo[] ladies = new Zahyo[NINZU];
		for(int i=0; i<NINZU; i++) {
			ladies[i] = new Zahyo(s.nextInt(), s.nextInt());
		}
		s.close();

		double maxDistance = TIME * SPEED;
		Zahyo takahashiA = new Zahyo(tXa, tYa);
		Zahyo takahashiB = new Zahyo(tXb, tYb);
		for(Zahyo lady : ladies) {
			if(calcDistance(takahashiA, lady, takahashiB) <= maxDistance) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	private static double calcDistance(Zahyo takahashiA, Zahyo lady, Zahyo takahashiB) {

		double distance = 	Math.sqrt(
								(lady.x - takahashiA.x) * (lady.x - takahashiA.x)
								+ (lady.y - takahashiA.y) * (lady.y - takahashiA.y))
							+
							Math.sqrt(
								(takahashiB.x - lady.x) * (takahashiB.x - lady.x)
								+ (takahashiB.y - lady.y) * (takahashiB.y - lady.y));

		return distance;
	}
}

class Zahyo {
	int x;
	int y;

	public Zahyo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}