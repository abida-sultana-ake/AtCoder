import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();
        // System.out.println(line);

		Scanner sc = new Scanner(System.in);
		// 整数の入力
		long a = sc.nextLong();
		// スペース区切りの整数の入力
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = 1000000007;
		// 文字列の入力
// 		String s = sc.next();
		// 出力
		long ans = a * b;
		ans = ans % d;
		ans = ans * c;
		ans = ans % d;
		System.out.println(ans);
		
		
    }
}
