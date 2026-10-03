import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = 0; i < n; i++){
			String[] tmpArray = br.readLine().split(" ");
			
			int start = Integer.parseInt(tmpArray[0]);
			int end = Integer.parseInt(tmpArray[1]);
			
			sum += end - start + 1;
		}
		
		System.out.println(sum);
	}

}
