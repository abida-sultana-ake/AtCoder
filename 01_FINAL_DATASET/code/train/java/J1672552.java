import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static char[] a;
	private static int aIndex = 0;
	private static char[] b;
	private static int bIndex = 0;
	private static char[] c;
	private static int cIndex = 0;
	
	private static char winner;
	
	public static void main(String[] args) throws Exception {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = reader.readLine();
			a = line.toCharArray();
			line = reader.readLine();
			b = line.toCharArray();
			line = reader.readLine();
			c = line.toCharArray();
		}
		char input = a[0];
		aIndex++;
		culculate(input);
		System.out.println(winner);
	}
	
	private static void culculate(char input) {
		char nextChar;
		switch (input) {
		case 'a' :
			if (aIndex == a.length) {
				winner = 'A';
				return;
			} else {
				nextChar = a[aIndex];
				aIndex++;
				culculate(nextChar);
				return;
			}
		case 'b' :
			if (bIndex == b.length) {
				winner = 'B';
				return;
			} else {
				nextChar = b[bIndex];
				bIndex++;
				culculate(nextChar);
				return;
			}
		case 'c' :
			if (cIndex == c.length) {
				winner = 'C';
				return;
			} else {
				nextChar = c[cIndex];
				cIndex++;
				culculate(nextChar);
				return;
			}
			default : throw new RuntimeException();
		}
	}
}
