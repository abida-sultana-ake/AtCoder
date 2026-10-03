
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
		String str = input.readLine( );
		int a = Integer.parseInt(str);
		int b = a/2;
		System.out.println(b * (a-b));
	}

}
