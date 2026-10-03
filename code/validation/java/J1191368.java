import java.util.Scanner;
//プロコン

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 0; i < 3; i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			sum = sum + (s * e)/10;
			
		}
		
		System.out.println(sum);
	

	}

}