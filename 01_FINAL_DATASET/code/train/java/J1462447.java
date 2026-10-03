import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		int num = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			num = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ABC" + num);
	}
}
