import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author 97797
 */
public class Main {
     public static void main(String[] args) {
        System.out.println(new Main().run(args, System.in));
    }
    public String run(String[] args, InputStream in) {
        String result = null;
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            int N = Integer.parseInt(reader.readLine());
            
            List<Integer> list = reader.lines()
                    .flatMap(s -> Stream.of(
                            s.replaceAll("\\s+", " ").split(" ")))
                    .limit(N).map(Integer::parseInt)
                    //.sorted(Comparator.reverseOrder())
                    .sorted()
                    .collect(Collectors.toList());
            int min = list.get(0);
            int max = list.get(N-1);
            result = String.valueOf(max-min);
        } catch (IOException ex) {

        }
        return result;
    }   
}
