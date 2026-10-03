
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
		String str = input.readLine( );
		String answer;

		if(str.replace(str.substring(0, 1), "").length() == 0){
			answer = "SAME";
		}else{
			answer = "DIFFERENT";
		}
		System.out.println(answer);
	}

}
