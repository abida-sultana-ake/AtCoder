import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String newStr = "";
		
		for(int i = input.length() - 1; i >= 0; i--){
			if(i % 2 == 1){
				continue;
			}
			String tmp1 = input.substring(0, i/2);
			String tmp2 = input.substring(i/2, i);
			
			//System.out.println("tmp1 "+ tmp1);
			//System.out.println("tmp2 "+ tmp2);
			
			if(tmp1.equals(tmp2)){
				newStr = new String(tmp1);
				break;
			}
		}
		
		System.out.println(newStr.length() * 2);

	}

}
