
import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by Seiya on 2016/10/16.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();

        ArrayList<Long> list = new ArrayList<Long>();
        long i = 1;
        double last = Math.sqrt(N);
        while(true){
            if(N % i == 0){
                list.add(N / i);
            }
            if(i > last)break;
            i++;
        }

        long ans = 99999999;
        for (int j = 0; j < list.size(); j++) {
            int temp = Math.max(log10(list.get(j)), log10(N / list.get(j)));
            ans = Math.min(ans, temp);
        }
        System.out.println(ans);


    } // mainMethod

    public static int log10(long n){
        int ans = 0;
        while(n > 0){
            n /= 10;
            ans++;
        }

        return ans;
    }


} // MainClass
