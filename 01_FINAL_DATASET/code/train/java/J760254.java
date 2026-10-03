import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] ans = new char[50];
		
		ans = input.toCharArray();
		if(ans[ans.length-1]=='T'){
			System.out.print("YES");
		}else{
			System.out.print("NO");
		}
	}

}
