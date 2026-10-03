import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author 97797
 */
public class Main {
    public static void main(String[] args) {
//        List list = Arrays.asList("()()", "(())");
//        Collections.sort(list);
//        System.out.println(list);
        System.out.println(new Main().run(args, System.in));
    }
    public String run(String[] args, InputStream in) {
        String result = null;
        try {            
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            int N = Integer.parseInt(reader.readLine());
            List<String> list = Stream.of(reader.readLine().split("")).collect(Collectors.toList());
            
            
            int L = 0;
            int R = 0;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (s.equals(")")) {
                    if (L == 0) {
                        R++;
                    } else {
                        L--;
                    }
                    if (R > 0) {
                        list.add(0, "(");
                        i++;
                        R--;
                    }                    
                } else {
                    L++;                    
                }
            }
            for (int i = 0; i < L; i++) {
                list.add(")");   
            }
            result = String.join("", list);            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
