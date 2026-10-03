import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            HashMap<Character, Integer> map = new HashMap<>();
            String s = in.nextLine();


            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, 0);
            }


            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int cnt = map.get(c);
                    map.put(c, ++cnt);
                }
            }

            boolean isDuplicate = false;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if ((int) pair.getValue() > 1) {
                    isDuplicate = true;
                    break;
                }
                isDuplicate = false;
            }

            if (isDuplicate) {
                out.println("no");
            } else {
                out.println("yes");
            }


        }

    }
}

