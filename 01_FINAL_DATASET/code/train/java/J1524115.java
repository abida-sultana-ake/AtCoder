import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    int N;
    int[] a;
    public void solve() {
        N = nextInt();
        a = new int[N];
        for(int i = 0;i < N;i++){
            a[i] = nextInt();
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i < N;i++){
            if(map.containsKey(a[i])) {
                map.put(a[i],map.get(a[i]) + 1);
            }else{
                map.put(a[i],1);
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        long ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                if(map.get(key) > 3){
                    ans = Math.max(ans,(long)key * key);
                }
                set.add(key);
            }
        }

        if(set.size() < 2){
            out.println(ans);
        }else{
            int first = set.pollLast();
            int second = set.pollLast();
            out.println(Math.max(ans,(long)first * second));
        }
    }

    public static void main(String[] args) {
        out.flush();
        new Main().solve();
        out.close();
    }

    /* Input */
    private static final InputStream in = System.in;
    private static final PrintWriter out = new PrintWriter(System.out);
    private final byte[] buffer = new byte[2048];
    private int p = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (p < buflen)
            return true;
        p = 0;
        try {
            buflen = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buflen <= 0)
            return false;
        return true;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrint(buffer[p])) {
            p++;
        }
        return hasNextByte();
    }

    private boolean isPrint(int ch) {
        if (ch >= '!' && ch <= '~')
            return true;
        return false;
    }

    private int nextByte() {
        if (!hasNextByte())
            return -1;
        return buffer[p++];
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = -1;
        while (isPrint((b = nextByte()))) {
            sb.appendCodePoint(b);
        }
        return sb.toString();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}