import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n % 2 == 1){
			System.out.println(n + 1);
		}
		else{
			System.out.println(n - 1);
		}

	}

}
