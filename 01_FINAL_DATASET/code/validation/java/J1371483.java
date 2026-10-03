
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		// Scanner scan = new Scanner(System.in);
		int a = Integer.parseInt(line);
		String[] ana = new String[100];
		ana = line.split("");


		if(a%3==0)
			System.out.println("YES");
		else{
			for(int i=0;i<ana.length;i++)
			{
				if(ana[i].equals("3"))
					System.out.println("YES");
				break;
			}
			System.out.println("NO");
		}

	}
}
