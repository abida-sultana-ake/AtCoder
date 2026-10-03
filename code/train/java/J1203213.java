import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<Point> personList = new ArrayList<>();
        List<Point> checkPointList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Point p = new Point(scanner.nextInt(), scanner.nextInt());
            personList.add(p);
        }
        for (int i = 0; i < M; i++) {
            Point p = new Point(scanner.nextInt(), scanner.nextInt());
            checkPointList.add(p);
        }

        for (Point person: personList) {
            long min = 1000000000;
            long minCheckPoint = -1;
            for (int i = 0; i < M; i++) {
                Point checkPoint = checkPointList.get(i);
                long d = Math.abs(person.x - checkPoint.x) + Math.abs(person.y - checkPoint.y);
                if (d < min) {
                    min = d;
                    minCheckPoint = i + 1;
                }
            }
            System.out.println(minCheckPoint);
        }
    }

    class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private class MyScanner {
        String[] s;
        int i;
        BufferedReader br;
        String reg = " ";

        MyScanner () {
            s = new String[0];
            i = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (i < s.length) return s[i++];
            String line = br.readLine();
            while (line.equals("")) {
                line = br.readLine();
            }
            s = line.split(reg, 0);
            i = 0;
            return s[i++];
        }

        public int nextInt() {
            try {
                return Integer.parseInt(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public double nextDouble() {
            try {
                return Double.parseDouble(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public long nextLong()  {
            try {
                return Long.parseLong(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
}
