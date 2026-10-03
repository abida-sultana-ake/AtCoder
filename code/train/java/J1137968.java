
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
		String strn = input.readLine( );
		int n = Integer.parseInt(strn);
		int[] list = new int[n+1];
		Arrays.fill(list, 0);
		long answer = 1;
		int x = 0;

		for(int i=1; i<n+1; i++){
			x = i;
			for(int j=1; j<i+1; j++){
				while((x)%(j) == 0){
					list[j] = list[j]+1;
					x = x / (j);
					if(j==1){
						break;
					}
				}
//				System.out.println("i="+i+",j="+j+",list["+j+"]="+list[j]);
			}
		}

		for(int i=2; i<n+1; i++){
//			System.out.println(list[i]);
			answer = answer * (list[i]+1);
			answer = answer % (int)(Math.pow(10, 9)+7);
		}

		System.out.println(answer);
	}

}

