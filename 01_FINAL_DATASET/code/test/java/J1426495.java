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
		
		String[] tmpArray = br.readLine().split(" ");
		int[] a = new int[n];
		long allSum = 0;
		for(int i = 0; i < n ; i++){
			a[i] = Integer.parseInt(tmpArray[i]);
			allSum += a[i];
		}
		
		//探索開始
		long absMin = Long.MAX_VALUE;
		long sunukeSum = 0;
		for(int i = 0; i < n - 1; i++){
			sunukeSum += a[i];
			long araiSum = allSum - sunukeSum;
			long tmpAbs = Math.abs(araiSum - sunukeSum);
			
			if(tmpAbs < absMin){
				absMin = tmpAbs;
			}
		}
		
		System.out.println(absMin);
	}

}
