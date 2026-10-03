import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		OneDReversi game = new OneDReversi();
		game.run();
	}
}

class OneDReversi {
	
	char[] stones;
	
	OneDReversi() {
		Scanner cin = new Scanner(System.in);
		this.stones = cin.nextLine().toCharArray();
	}
	
	void run() {
		int count = 0;
		char previousStone = stones[0];
		for (int i = 1; i < stones.length; i++) {
			if (previousStone != stones[i]) {
				count++;
			}
			previousStone = stones[i];
		}
		System.out.println(count);
	}
}
