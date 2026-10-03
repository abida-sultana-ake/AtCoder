import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(solve(A, B));
	}

	static int solve(int A, int B) {
		int now = A, count = 0;
		if (A == B)
			return 0;
		else {
			while (now != B) {
				if ((B - now) >= 8)
					now += 10;
				else if ((B - now) <= -8)
					now -= 10;
				else if ((B - now) >= 3)
					now += 5;
				else if ((B - now) <= -3)
					now -= 5;
				else if (B > now)
					now++;
				else
					now--;
				count++;
			}
			return count;
		}
	}
}