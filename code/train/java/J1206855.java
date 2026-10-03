import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
        if (Integer.parseInt(input.readLine()) < 1200) {
            System.out.println("ABC");
        } else {
            System.out.println("ARC");
        }
    }
}
