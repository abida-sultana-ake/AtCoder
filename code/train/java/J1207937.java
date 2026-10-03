import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = input.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);
        if ((b-a) == (c-b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
