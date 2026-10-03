
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		//Scanner scan = new Scanner(System.in);

	String[] str = new String[4];
	str = line.split("");
	
	if(str[0].equals(str[1])){
		if(str[2].equals(str[1])){
			if(str[2].equals(str[3])){
				System.out.println("SAME");}
			else
				System.out.println("DIFFERENT");}
		else
			System.out.println("DIFFERENT");}
	else
		System.out.println("DIFFERENT");
	
			
	}
}