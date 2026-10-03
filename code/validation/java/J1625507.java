import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        if(n == 1) {
            System.out.println("ABC");
        } else {
            System.out.println("chokudai");
        }
    }
}