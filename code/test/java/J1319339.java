import java.net.SecureCacheResponse;
import java.util.Random;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
 
        int a ,b, c;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
 
        if(a + b == c || b + c == a || c + a == b){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
 
 
    }
}