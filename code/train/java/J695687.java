import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Integer> resultMap;
    Set<Integer> keySet;
    List<Integer> keyList;
    int N = 0;
    int[] a;
    int Count = 0;

    public static void main(String[] args) throws Exception{
        new Main().solve();
    }

    void solve() throws Exception {
        resultMap = new HashMap<>();
        keySet = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            keySet.add(a[i]);
        }
        keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);
        for (Integer i : keyList) {
            resultMap.put(i, Count);
            Count++;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(resultMap.get(a[i]));
        }
    }
}
