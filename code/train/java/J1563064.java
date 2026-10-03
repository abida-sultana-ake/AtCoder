
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    private static boolean IS_TEST = false;

    public static void main(String[] args) throws Throwable {
        InputStream is = null;
        if (IS_TEST) {
            String input = "5\n"
                + "1 4 3 5 2";
            is = new ByteArrayInputStream(input.getBytes());
        } else {
            is = System.in;
        }
        try (BufferedReader r = new BufferedReader(new InputStreamReader(is))) {
            int N = readInt(r);
            int[] ps = readInts(r);

            int manipCount = 0;
            for (int i = 0; i < ps.length; i++) {
                if (ps[i] == i + 1) {
                    if (i == ps.length - 1) {
                        int buf = ps[i - 1];
                        ps[i - 1] = i;
                        ps[i] = buf;
                        manipCount++;
                    } else {
                        int buf = ps[i + 1];
                        ps[i + 1] = i;
                        ps[i] = buf;
                        manipCount++;
                    }
                }
            }
            System.out.println(manipCount);
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

    private static void log(Object... logs) {
        if (IS_TEST) {
            StackTraceElement ste[] = Thread.currentThread().getStackTrace();
            String clazz = "UK";
            if (ste.length > 2) {
                clazz = ste[2].getClassName().replaceAll("^.+\\.", "") + "-" + ste[2].getMethodName();
            }
            System.out.println("*LOG*\t" + clazz + "\t" + Arrays.stream(logs).map(o -> Objects.toString(o)).collect(Collectors.joining("\t")));
        }
    }

    private static String toString(Object obj) {
        List<String> values = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                Object val = f.get(obj);
                if (val != null) {
                    values.add(f.getName() + "=" + Objects.toString(val));
                }
            } catch (Exception e) {
            }
        }
        return obj.getClass().getSimpleName() + " {" + String.join(", ", values) + "}";
    }

}
