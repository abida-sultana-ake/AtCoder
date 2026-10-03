
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line = br.readLine();
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        
        
        if(a==100)
        System.out.println("Perfect");
        else if(a>=90)
        	System.out.println("Great");
        else if(a>=60)
        	System.out.println("Good");
        else 
        	System.out.println("Bad");
        
        	
	}
}
