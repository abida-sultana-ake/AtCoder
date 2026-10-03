import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    BigInteger k;

    public static void main(String[] args) {
        Main m = new Main();
        m.read();
        m.solve();
    }

    void read() {
        Scanner sc = new Scanner(System.in);
        k = new BigInteger(sc.nextLine());
    }

    void solve() {
        BigInteger n = new BigInteger("50");
        BigInteger div = k.divide(n);
        BigInteger mod = k.mod(n);
        int _mod = Integer.parseInt(mod.toString());
        BigInteger[] as = new BigInteger[50];
        for (int i = 0; i < 50; i++) {
            as[i] = div.add(new BigInteger(i+""));
//            as[i] = as[i].subtract(mod);
        }
        for (int i = 0; i < _mod; i++) {
            as[i] = as[i].add(n);
            for (int j = 0; j < 50; j++)
                if (i != j)
                    as[j] = as[j].subtract(BigInteger.ONE);
        }
        System.out.println(50);
        for (int i = 0; i < 49; i++)
            System.out.printf("%s ", as[i].toString());
        System.out.println(as[49].toString());
    }
}
