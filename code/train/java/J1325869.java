import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int calcMax(int max, int[] haiten) {
		if(max%10 != 0) {
			return max;
		}

		Arrays.sort(haiten);
		for(int i=0; i<haiten.length; i++) {
			if(haiten[i]%10 != 0) {
				return max - haiten[i];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] haiten = new int[n];
		int max = 0;
		for(int i=0; i<n; i++) {
			haiten[i] = sc.nextInt();
			max += haiten[i];
		}
		sc.close();

		System.out.println(calcMax(max, haiten));
	}
}
