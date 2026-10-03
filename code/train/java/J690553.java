import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 入力
		int n;	//1≤N≤50
		String[][] s;	//si,j は o または x である
		try(Scanner scan = new Scanner(System.in)) {
			n = scan.nextInt();
			s = new String[n][];
			for (int i = 0; i < n; i++) {
				s[i] = new String[n];
				String line = scan.next();
				for (int j = 0; j < n; j++) {
					s[i][j] = line.substring(j, j + 1);
				}
			}
		}
		
		// マス目を時計回りに 90 度回転した結果 (i,j)に来るものは、(n-1-j,i)にあったものである。
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result.append(s[n - 1 - j][i]);
			}
			result.append("\n");
		}
		
		System.out.print(result.toString());
	}

}