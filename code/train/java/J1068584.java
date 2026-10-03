import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zzt on 17-1-16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int L = scanner.nextInt();

        UnionFind road = new UnionFind(N);
        UnionFind railway = new UnionFind(N);

        for (int i = 0; i < K; i++) {
            road.union(scanner.nextInt() - 1, scanner.nextInt() - 1);
        }
        for (int i = 0; i < L; i++) {
            railway.union(scanner.nextInt() - 1, scanner.nextInt() - 1);
        }
        Map<Long, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long key = (long) road.find(i) * N +railway.find(i);
            if (count.containsKey(key))
                count.put(key, count.get(key) + 1);
            else
                count.put(key, 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long key = (long) road.find(i) * N +railway.find(i);
            sb.append(count.get(key)).append(" ");
        }
        System.out.println(sb);
    }

    static class UnionFind {
        private int[] id;
        private int count;
        private int[] sz;

        public UnionFind(int n) {
            count = n;
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);

            if (i == j)
                return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = id[i];
                sz[i] += sz[j];
            }
            count--;
        }
    }
}