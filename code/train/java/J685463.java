import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main();
	}

	public Main() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();

		String line = br.readLine().trim();
		int t = Integer.parseInt(line);
		br.close();

		final int len = s.length();
		int x = 0, y = 0;
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == 'U') {
				y++;
			} else if (s.charAt(i) == 'R') {
				x++;
			} else if (s.charAt(i) == 'D') {
				y--;
			} else if (s.charAt(i) == 'L') {
				x--;
			} else {
				cnt++;
			}
		}

		int d = Math.abs(x) + Math.abs(y);
		if (t == 1) {
			System.out.println((d + cnt));
		} else {
			if (d >= cnt) {
				System.out.println((d - cnt));
			} else {
				int sub = cnt - d;
				System.out.println((sub % 2));
			}
		}
	}
}
