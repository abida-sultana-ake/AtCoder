
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line = br.readLine();
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();

		if(str1.length()>str2.length())
			System.out.println(str1);
		else
			System.out.println(str2);

	}
}