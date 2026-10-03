import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            // 標準入力
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            boolean flag = false;
            HashMap<String, String> hm = new HashMap<String, String>();
            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(i, i + 1);
                if (hm.containsKey(tmp)) {
                    System.out.println("no");
                    flag = true;
                    break;
                } else {
                    hm.put(tmp, tmp);
                }
            }
            if (!flag) {
                System.out.println("yes");
            }
       } catch (IOException e) {
            e.printStackTrace();
       }
    }
}
