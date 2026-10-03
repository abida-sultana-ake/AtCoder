import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int strN = 1; // 文字列を何行受け取るか
		for (int i = 0; i < strN; i++) {
			line += br.readLine() + " ";
		}
		String[] param = line.split(" ");
		AZ(param);

	}

	static void AZ(String[] param) {

		System.out.println((param[0].lastIndexOf("Z")) - (param[0].indexOf("A")) + 1);
	}
}