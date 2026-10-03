import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by takaesumizuki on 2017/06/14.
 */
public class Main {
    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> douga = new ArrayList<>();
        ArrayList<Integer> sorted_douga = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            douga.add(sc.nextInt());
        }
        douga.stream().sorted((a,b) -> b - a).forEach(sorted_douga::add);
        double sum = 0.0;
        for(int i = 0; i < K; i++){
            sum += (sorted_douga.get(i) / Math.pow(2.0,i+1));
        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        new Main().run();
    }

}
