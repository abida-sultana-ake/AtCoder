
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[M];
    for(int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
    }
    for(int i = 0; i < M; i++) {
      b[i] = sc.nextInt();
    }
    int ans = 0;
    int airport = 0;
    int time = 0;
    while(time <= 1000000000) {
      if(airport == 0) {
        int i = binary_search(a, time);
        if(i != -1) {
          airport = 1;
          time = a[i] + X;
        } else {
          break;
        }
      } else {
        int i = binary_search(b, time);
        if(i != -1) {
          airport = 0;
          time = b[i] + Y;
          ans++;
        } else {
          break;
        }
      }
    }
    System.out.println(ans);
  }

  // 配列aの項の内、t以上のもので最も小さいインデックスを返す(なければ-1を返す)
  public static int binary_search(int[] a, int t) {
    int l = 0;
    int r = a.length;
    int ans = -1;
    while(r - l >= 1) {
      int med = (l + r) / 2;
      if(a[med] >= t) {
        ans = med;
        r = med;
      } else {
        l = med + 1;
      }
    }
    return ans;
  }

  // 配列bの項の内、t以上のもので最も小さいインデックスを返す(なければ-1を返す)
  public static int binary_search2(int[] b, int t) {
    int l = 0;
    int r = b.length;
    int ans = -1;
    while(r - l >= 1) {
      int med = (l + r) / 2;
      if(b[med] >= t) {
        ans = med;
        r = med;
      } else {
        l = med + 1;
      }
    }
    return ans;
  }
}