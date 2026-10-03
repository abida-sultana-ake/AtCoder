import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ARC007ASolve solve = new ARC007ASolve();
		solve.main();
	}
}

class ARC007ASolve {
	
	char X;
	String x;
	
	ARC007ASolve() {
		Scanner cin = new Scanner(System.in);
		this.X = cin.next().charAt(0);
		this.x = cin.next();
	}
	
	void main() {
		StringBuffer sb = new StringBuffer(x.length());
		for (char c: x.toCharArray()) {
			if (c == X) {
				continue;
			}
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
