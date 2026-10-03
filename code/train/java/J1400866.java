import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author zyc
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[3 * n];
            for (int i = 0; i < 3 * n; ++i) a[i] = in.nextInt();
            long[] front = getFront(a, n);
            long[] back = getBack(a, n);
            long res = Long.MIN_VALUE;
            for (int i = n - 1; i < 2 * n; ++i) {
                res = Math.max(res, front[i] - back[i + 1]);
            }
            out.println(res);
        }

        private long[] getFront(int[] a, int sz) {
            TreeMap<Integer, Integer> mm = new TreeMap<>();

            long sum = 0;
            for (int i = 0; i < sz; ++i) {
                if (mm.containsKey(a[i])) {
                    mm.put(a[i], mm.get(a[i]) + 1);
                } else {
                    mm.put(a[i], 1);
                }
                sum += a[i];
            }

            long[] front = new long[3 * sz];
            front[sz - 1] = sum;
            for (int i = sz; i < 2 * sz; ++i) {
                if (a[i] > mm.firstKey()) {
                    sum += a[i] - mm.firstKey();
                    if (mm.containsKey(a[i])) {
                        mm.put(a[i], mm.get(a[i]) + 1);
                    } else {
                        mm.put(a[i], 1);
                    }
                    if (mm.get(mm.firstKey()) == 1) {
                        mm.remove(mm.firstKey());
                    } else {
                        mm.put(mm.firstKey(), mm.get(mm.firstKey()) - 1);
                    }
                }
                front[i] = sum;
            }

            return front;
        }

        private long[] getBack(int[] a, int sz) {
            TreeMap<Integer, Integer> mm = new TreeMap<>();

            long sum = 0;
            for (int i = 3 * sz - 1; i >= 2 * sz; --i) {
                if (mm.containsKey(a[i])) {
                    mm.put(a[i], mm.get(a[i]) + 1);
                } else {
                    mm.put(a[i], 1);
                }
                sum += a[i];
            }

            long[] back = new long[3 * sz];
            back[2 * sz] = sum;
            for (int i = 2 * sz - 1; i >= sz; --i) {
                if (a[i] < mm.lastKey()) {
                    sum += a[i] - mm.lastKey();
                    if (mm.containsKey(a[i])) {
                        mm.put(a[i], mm.get(a[i]) + 1);
                    } else {
                        mm.put(a[i], 1);
                    }
                    if (mm.get(mm.lastKey()) == 1) {
                        mm.remove(mm.lastKey());
                    } else {
                        mm.put(mm.lastKey(), mm.get(mm.lastKey()) - 1);
                    }
                }
                back[i] = sum;
            }

            return back;
        }

    }
}

