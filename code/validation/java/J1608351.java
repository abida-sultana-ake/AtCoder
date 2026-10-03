import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int solve(Scanner scanner) {
        String[] line = scanner.nextLine().split(" ");
        int X = Integer.parseInt(line[0]);
        int t = Integer.parseInt(line[1]);
        int ret = X - t;

        return ret > 0 ? ret : 0;
    }

    public static void main(String[] args) {
//        tests();

        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner));
    }

    private static String ex1 = "100 17";
    private static String ex2 = "48 58";
    private static String ex3 = "1000000000 1000000000";

    private static void tests() {
        System.out.println(solve(new Scanner(testCaseToInputStream(ex1))));
        System.out.println(solve(new Scanner(testCaseToInputStream(ex2))));
        System.out.println(solve(new Scanner(testCaseToInputStream(ex3))));
    }

    private static ByteArrayInputStream testCaseToInputStream(String ex) {
        try {
            return new ByteArrayInputStream(ex.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}