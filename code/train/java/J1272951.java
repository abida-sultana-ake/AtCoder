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
    public static int gcd(int a, int b){
        return b==0 ? a : gcd(b, a % b);
    }

    public static void solve2(){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (c % gcd(a,b)==0){

            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
    public static void main(String[] argc) {
        solve2();
    }
}
