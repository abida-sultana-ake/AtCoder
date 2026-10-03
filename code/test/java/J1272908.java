import java.io.BufferedInputStream;
        import java.util.Scanner;

/**
 *
 */
public class Main {

    public static void solve(){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String[] str = sc.nextLine().split(" ");
        if (str[0].charAt(str[0].length()-1) == str[1].charAt(0) &&
                str[1].charAt(str[1].length()-1) ==
                        str[2].charAt(0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
    public static void main(String[] argc) {
        solve();
    }
}
