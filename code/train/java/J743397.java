import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line.charAt(line.length()-1) == 'T') System.out.println("YES");
        else System.out.println("NO");
    }
}
