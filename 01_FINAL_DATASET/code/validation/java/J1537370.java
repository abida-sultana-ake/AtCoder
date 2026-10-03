import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Integer[] inputs = new Integer[N];
		for(int i=0; i<N; i++) {
			Integer a = sc.nextInt();	// 1<=a_i<=1_000_000_000
			while(a%2 == 0) {
				a /= 2;
			}
			inputs[i] = a;
		}
		sc.close();

		Set<Integer> nums = new HashSet<>(Arrays.asList(inputs));

		System.out.println(nums.size());

	}

}