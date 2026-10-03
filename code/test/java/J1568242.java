import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Main {

    private final List<String> candidates;
    private final String input;
    private final int passwordLen;
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int passwordLen = sc.nextInt();
        int answer = new Main(input, passwordLen).resolve();
        System.out.println(answer);
    }

    public Main(String input, int passwordLen) {
        this.candidates = new ArrayList<>();
        this.input = input;
        this.passwordLen = passwordLen;
    }

    
    public int resolve() {
        if (input.length() < passwordLen) {
            return 0;
        }

        char[] arr = input.toCharArray();

        int index = 0;

        while (index <= input.length() - passwordLen) {
            
            // extract word
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < passwordLen; i++) {
                sb.append(arr[index + i]);
            }
            String candidate = sb.toString();
            if (!candidates.contains(candidate)) {
                candidates.add(candidate);
            }
            index++;
        }
        return candidates.size();
    }
}
