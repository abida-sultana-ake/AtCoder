import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // 部下リスト
    HashMap<Integer, ArrayList<Integer>> sub = new HashMap<Integer, ArrayList<Integer>>();
    for(int i = 0; i < N; i++) {
      sub.put(i, new ArrayList<Integer>());
    }
    for(int i = 1; i < N; i++) {
      int boss = sc.nextInt() - 1;
      ArrayList<Integer> list = sub.get(boss);
      list.add(i);
      sub.put(boss, list);
    }
    System.out.println(dfs(sub, 0));
  }

  public static int dfs(HashMap<Integer, ArrayList<Integer>> sub, int id) {
    ArrayList<Integer> list = sub.get(id);
    if(list.size() == 0) return 1;
    int max = 0;
    int min = Integer.MAX_VALUE;
    for(int i : list) {
      max = Math.max(max, dfs(sub, i));
      min = Math.min(min, dfs(sub, i));
    }
    return max + min + 1;
  }
}