import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String str1 = "TAKAHASHIKUN";
            String str2 = "Takahashikun";
            String str3 = "takahashikun";
            String [] w = new String[50];
            int cnt = 0;
            int N = sc.nextInt();
            for (int i = 0; i < N ; i++) {
               String list = sc.next();
               if  ( i == N -1) {
                 list = list.substring(0, list.length() - 1);
               }
               if (str1.equals(list)) {
                 cnt++;
               } else if (str2.equals(list)) {
                 cnt++;
               } else if (str3.equals(list)) {
                  cnt++;
               }
            }
            System.out.println(cnt);
  }
private static String deleteAfterSpecifiedCharactor(String text, String spec) {
          System.out.println("text " + text);
          System.out.println("spec " + spec);
          if (!text.contains(spec)) {
            return text;
        }

        return text.substring(0, text.indexOf(spec) + spec.length());
    }
}       