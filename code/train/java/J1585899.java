import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double result = 0;
        for(int i = 1; i <= n; i++) {
            result = result + (10000 * i);
        }
        result = result / n;
        System.out.println(result);
    }
}