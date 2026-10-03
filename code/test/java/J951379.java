import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		String result = "";
		int n = sc.nextInt();
		int x=sc.nextInt();
		int a=n-x;
		int b=x-1;
		if(a<b){
			result=""+a;
		}else{
			result=""+b;
		}
		System.out.println(result);

	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}

}