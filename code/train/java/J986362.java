import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		int a, b, h;

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);

		a = Integer.parseInt(in.readLine());
		b = Integer.parseInt(in.readLine());
		h = Integer.parseInt(in.readLine());

		System.out.println((a + b) * h / 2);
	}
}
