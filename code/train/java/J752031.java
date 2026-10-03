import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        Main instance = new Main();
        sc = instance.new Scanner();
        instance.solve();
    }

    private void solve() {
        try {
        	double n = sc.nextInt();
        	BigDecimal a = new BigDecimal(10);
        	BigDecimal a1 = new BigDecimal(10);
        	BigDecimal a2 = new BigDecimal(7);
        	for(int i = 1; i < n; i++){
        		a = a.multiply(a1);
        	}
        	
            System.out.println(a.add(a2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Scanner {
        String[] s;
        int i;
        BufferedReader br;
        String regex = " ";

        public Scanner() {
            s = new String[0];
            i = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                super.finalize();
            } finally {
                destruction();
            }
        }

        private void destruction() throws IOException {
            if (br != null) br.close();
        }

        public String next() throws IOException {
            if (i < s.length) return s[i++];
            String st = br.readLine();
            while (st == "") st = br.readLine();
            s = st.split(regex, 0);
            i = 0;
            return s[i++];
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        public Long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        public Double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }
    }
}