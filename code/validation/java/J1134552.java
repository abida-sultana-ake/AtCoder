import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		n = 2025 - n;

		for (int i = 1; i <= 9; i++) {
			for (int k = 1; k <= 9; k++) {
				if (i * k == n) {
					System.out.println(i + " x " + k);
				}
			}
		}
	}

}
