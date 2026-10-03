import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			int N = Integer.parseInt(str);
			str = br.readLine();
			int A = Integer.parseInt(str);
 
			System.out.println(N*N-A);
		}catch (Exception e) {
			System.exit(0);
		}
	
	}
 
}