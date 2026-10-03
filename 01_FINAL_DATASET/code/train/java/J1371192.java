
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line = br.readLine();
		Scanner scan = new Scanner(System.in);


		int a = Integer.parseInt(scan.next());
		int b = Integer.parseInt(scan.next());

		System.out.println(b/a);
	}
}
