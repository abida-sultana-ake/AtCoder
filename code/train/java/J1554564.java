import java.util.*;

public class Main {
    private static int n;
    private static String str;

    public static void input(){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        str = scan.next();

    }

    public static void main(String args[]) {
        //入力
        input();

        double sum = 0;
        for (int i=0;i<n;i++){
            switch (str.charAt(i)){
                case 'A':sum+=4;break;
                case 'B':sum+=3;break;
                case 'C':sum+=2;break;
                case 'D':sum+=1;break;
                default:break;
            }
        }
        System.out.println(sum/n);
    }
}
