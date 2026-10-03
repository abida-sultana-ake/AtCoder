import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] lineStr = br.readLine().split("");
		StringBuilder outputStr = new StringBuilder();
		for(String str:lineStr){
			if(!str.equals("a")&&!str.equals("i")&&!str.equals("u")&&!str.equals("e")&&!str.equals("o")){
				outputStr.append(str);
			}
		}
		System.out.println(outputStr);
	}
}