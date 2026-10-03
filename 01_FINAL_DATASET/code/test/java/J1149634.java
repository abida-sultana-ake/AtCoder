import java.util.Scanner;

public class Main {

	static int card[] = {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		while(N > 30){
			N = N % 30;
		}
		
		for(int i=0;i<N;i++){
			replace(i % 5);
		}
		
		for(int i=0;i<6;i++){
			System.out.print(card[i]);
		}
	}

	private static void replace(int remainder) {
		int temp;
		
		temp = card[remainder];
		card[remainder] = card[remainder + 1];
		card[remainder + 1] = temp;
	}

}
