

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str = br.readLine();
			char c = str.charAt(str.length()-1);
			System.out.println((c=='T')?"YES":"NO");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
