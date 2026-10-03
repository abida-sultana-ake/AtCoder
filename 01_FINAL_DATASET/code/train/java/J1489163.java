import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        String head = str.substring(0, 1);
        String foot = str.substring(len-1, len);
        
        System.out.println(head + Integer.toString(len-2) +  foot);
    }
    
}
