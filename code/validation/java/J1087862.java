import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);  
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        for (int i = 0;i < n;i++) {
            set.add(sc.nextInt());
        }
        int s = set.size();
        if (s%2==0) s--;
        System.out.println(s);
    }
}
