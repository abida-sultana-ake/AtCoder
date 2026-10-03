import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h1 = Integer.parseInt(br.readLine());
		if(!(0<=h1 && h1<=2000)){
			throw new IllegalArgumentException();
		}
		int h2 = Integer.parseInt(br.readLine());
		if(!(0<=h2 && h2<=2000)){
			throw new IllegalArgumentException();
		}
		System.out.println(h1 - h2);
	}
}