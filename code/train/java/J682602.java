import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char a = Character.toLowerCase(line.charAt(0));
		char b = line.charAt(2);
		if(a==b){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}

}
