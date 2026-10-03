import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        String c = scanner.next();

        char al = a.charAt(a.length()-1); //文字列aの最後の文字
        char bf = b.charAt(0);            //文字列bの最初の文字
        char bl = b.charAt(b.length()-1); //文字列bの最後の文字
        char cf = c.charAt(0);            //文字列cの最初の文字

        if(al == bf && bl == cf) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
