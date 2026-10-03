import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String s  = br.readLine();

		if(s.equals("a")){
			System.out.println("-1");
		}else {
			System.out.println("a");
		}
	}
}
