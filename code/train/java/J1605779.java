import java.io.*;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    static long dist[][];
    static long ans;
    static void solve(int array[], int start, int end) {
        if (start == end) {
            long temp = 0;
            for (int i = 1; i < array.length - 1; i++)
                temp += dist[array[i]][array[i + 1]];
            ans = Math.min(ans, temp);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(array, start, i);
            solve(array, start + 1, end);
            swap(array, start, i);
        }
    }
    static void swap(int array[], int start, int idx){
        int temp = array[start];
        array[start] = array[idx];
        array[idx] = temp;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int array[] = new int[r + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < array.length; i++)
            array[i] = Integer.parseInt(st.nextToken());
        dist = new long[n + 1][n + 1];
        for(int i = 1;i <= n;i++)
            Arrays.fill(dist[i], Long.MAX_VALUE / 2);
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = c;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
        ans = Long.MAX_VALUE;
        solve(array, 1, r);
        System.out.print(ans);
    }
 
}