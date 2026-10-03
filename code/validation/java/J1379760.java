import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		// Scanner scan = new Scanner(System.in);
		
		switch(line){
		case "A":
			System.out.println(1);
			break;
		case "B":
			System.out.println(2);
			break;
		case "C":
			System.out.println(3);
			break;
		case "D":
			System.out.println(4);
			break;
		case "E":
			System.out.println(5);
			break;
			
		}
		
	}

}