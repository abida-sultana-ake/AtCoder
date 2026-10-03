
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line = br.readLine();
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    
    if(a+b==c)
    	System.out.println("Yes");
    else if(a+c==b)
    	System.out.println("Yes");
    else if(c+b==a)
    	System.out.println("Yes");
    else
    	System.out.println("No");

	}
}
