import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(a59_b(sc.next(),sc.next()));
    }

    static String a59_b(String i1, String i2) {
        BigInteger b1 = new BigInteger(i1);
        BigInteger b2 = new BigInteger(i2);

        int i = b1.compareTo(b2);
        if (i == -1) {
            return "LESS";
        } else if (i == 1) {
            return "GREATER";
        } else {
            return "EQUAL";
        }
    }
}
