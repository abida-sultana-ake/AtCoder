import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ABC060ASolver solver = new ABC060ASolver();
		solver.main();
	}
}

class ABC060ASolver {
	
	String wordA;
	String wordB;
	String wordC;
	
	public ABC060ASolver() {
		Scanner cin = new Scanner(System.in);
		this.wordA = cin.next();
		this.wordB = cin.next();
		this.wordC = cin.next();
	}
	
	void main() {
		char lastALetter = wordA.charAt(wordA.length() - 1);
		char firstBLetter = wordB.charAt(0);
		char lastBLetter = wordB.charAt(wordB.length() - 1);
		char firstCLetter = wordC.charAt(0);
		
		if (lastALetter == firstBLetter && lastBLetter == firstCLetter) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
}