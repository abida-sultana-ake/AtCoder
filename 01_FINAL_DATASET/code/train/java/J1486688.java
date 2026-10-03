import java.util.Scanner;

public class Main {
	private Scanner sc;
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		sc = new Scanner(System.in);

		int nico = Integer.parseInt(sc.nextLine());

		int[] mul = new int[3];
		for (int i = 0; i < mul.length; i++) {
			mul[i] = 0;
		}
		
		for (int i = 0; i < nico; i++) {
			int num = sc.nextInt();
			
			if (num % 2 != 0) {
				mul[0]++;
			} else if ((num / 2) % 2 != 0) {
				mul[1]++;
			} else {
				mul[2]++;
			}
		}
		
		String ans = "Yes";
		if (mul[0] == (mul[2] + 1)) {
			if (mul[1] != 0) ans = "No";
		} else if (mul[0] > (mul[2] + 1)) {
			ans = "No";
		}
		

		System.out.println(ans);
	}
}