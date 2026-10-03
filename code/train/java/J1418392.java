import java.util.*;
 
class Main {
  public static int saiki(int cur, List<Integer> group, final boolean[][] shaken, final int N) {
    if (cur >= N)
      return group.size();
 
    int lResult = saiki(cur+1, group, shaken, N);
 
    for (int i = 0; i < N; i++)
      if (group.contains(i) && !shaken[cur][i])
        return lResult; // Right ha yaranai
 
    group.add(0, cur);
    int rResult = saiki(cur+1, group, shaken, N);
    group.remove(0);
 
    return Math.max(rResult, lResult);
  }
 
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
 
    final int N = sc.nextInt();
    final int M = sc.nextInt();
    boolean[][] shaken = new boolean[N][N];
 
    for (int i = 0; i < M; i++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      shaken[x][y] = true;
      shaken[y][x] = true;
    }
 
    List<Integer> l = new ArrayList<Integer>();
    int result = saiki(0, l, shaken, N);
    System.out.println(result);
  }
}