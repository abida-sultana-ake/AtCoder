import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int a = sc.nextInt();

		if (Integer.valueOf(a).equals(1)) {
			System.out.println("ABC");
		}else {
			System.out.println("chokudai");
		}

	}

}
