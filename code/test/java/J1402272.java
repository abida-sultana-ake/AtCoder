
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ",0);
		String str = line[0] + line[1];

		int x = Integer.valueOf(str);

		System.out.println(x*2);

	}
}
