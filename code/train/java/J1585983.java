import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] array = str.split(" ");

		int x = Integer.parseInt(array[0]);
		int y = Integer.parseInt(array[1]);
		System.out.println(y/x);
	}
}
