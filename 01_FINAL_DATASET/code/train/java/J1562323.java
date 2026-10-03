
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Throwable {
        InputStream is = null;
        if (false) {
            String input = "1\n" +
"99999";
            is = new ByteArrayInputStream(input.getBytes());
        } else {
            is = System.in;
        }
        try (BufferedReader r = new BufferedReader(new InputStreamReader(is))) {
            int N = readInt(r);
            int[] as = readInts(r);
            int[] counts = new int[(int)Math.pow(10, 5)];

            for (int a : as) {
                counts[a]++;
            }

            int max = -1;
            int maxIndex = -1;
            for (int i = 0; i < counts.length; i++) {
                int before = i == 0 ? 0 : counts[i - 1];
                int after = i == counts.length - 1 ? 0 : counts[i + 1];
                int total = before + after + counts[i];
                if (total > max) {
                    max = total;
                    maxIndex = i;
                }
            }
            System.out.println(max);
        }
    }

    private static int readInt(BufferedReader r) throws IOException {
        return Integer.parseInt(r.readLine());
    }

    private static int[] readInts(BufferedReader r) throws IOException {
        String[] data = r.readLine().split("\\s");
        int[] vals = new int[data.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.parseInt(data[i]);
        }
        return vals;
    }

}
