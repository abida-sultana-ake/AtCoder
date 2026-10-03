import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		int limit = 1000000000;
//		
//		boolean[] written = new boolean[limit];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] input = new int[n];
		for(int i = 0; i < n; i++){
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		boolean written = true;
		
		int write = 1;
		int erase = 0;
		
		for(int i = 1; i < n; i++){
			if(input[i - 1] == input[i]){
				written = !written;
			}
			
			else {
				written = true;
			}
			
			if(written == true){
				write++;
			}
			else {
				erase++;
			}
		}
		
		System.out.println(write - erase);
	}

}
