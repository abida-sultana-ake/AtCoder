import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long a = scanner.nextInt(); // walk
		long b = scanner.nextInt(); // telaport
		
		long count = 0l;
		int tmp = scanner.nextInt(); // 始めの場所
		for (int i = 1; i < n; i++) {
			int pos = scanner.nextInt();
			long aMove = (pos - tmp) * a;
			if (aMove > b) {
				count += b;
			}else {
				count += aMove;
			}
			tmp = pos;
		}
		System.out.println(count);
	}
}