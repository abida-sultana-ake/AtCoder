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
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		System.out.println(calcColorPattern(str1, str2, n));
	}
	
	public static int calcColorPattern(String str1, String str2, int n){
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		long result = 1;
		
		final int V = 0;
		final int H = 1;
		int prevType = -1;
		
		for(int i = 0; i < n;){
			//縦
			if(array1[i] == array2[i]){
				if(i == 0){
					result *= 3;
				}
				else if(prevType == V){
					result *= 2;
				}
				
				prevType = V;
				i++;
			}
			//横
			else {
				if(i == 0){
					result *= 6;
				}
				else if(prevType == V){
					result *= 2;
				}
				else {
					result *= 3;
				}
				prevType = H;
				i += 2;
			}
			result %= 1000000007;
		}
		
		return (int) (result%1000000007);
	}

}
