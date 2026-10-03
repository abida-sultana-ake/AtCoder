
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
	Scanner sc	= new Scanner(System.in);
	String w = sc.next();

	w = w.replaceAll("a|i|u|e|o", "");

	System.out.println(w);

	}
}
