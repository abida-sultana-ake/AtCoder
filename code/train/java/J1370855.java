

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line[] = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		int c = Integer.parseInt(line[2]);

		int num[] = { a, b, c };
		Arrays.sort(num);
		System.out.println(num[1]);

	}
}