import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n = sc.nextInt();

		if(n==12){
			System.out.println("1");
		}else {
			System.out.println(n+1);
		}

	}

}
