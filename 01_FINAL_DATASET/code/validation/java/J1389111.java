
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner scan = new Scanner(System.in);

		String[] str = new String[12];
		int count = 0;
		for (int i = 0; i <= 11; i++)
			str[i] = br.readLine();

		for (int h = 0; h < 12; h++)
			for (int j = 0; j < str[h].length(); j++)
				if (str[h].substring(j, j+1).equals("r")) {
					count++;
					break;
				}

		System.out.println(count);
	}
}