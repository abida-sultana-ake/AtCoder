import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.next();
        String ans = "";
        if (str.charAt(str.length()-1) == 'T') {
            ans = "YES";
        }
        else {
            ans = "NO";
        }
		System.out.println(ans);
    }
}
