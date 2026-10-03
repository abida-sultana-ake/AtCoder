import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine();
            int alp[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int index = (int)str.charAt(i) - 97;
                alp[index]++;
            }
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if (alp[i] == 0) {
                    System.out.println((char)(i + 97));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("None");
            }
        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
