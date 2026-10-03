import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //
		int X = Integer.parseInt(br.readLine());
		int t = 0;
		int sum = 0;
		
		while (true) {
			sum += ++t;
        	if (sum >= X) { System.out.println(t); return; }
		}

    }

}