import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String c[] = new String[100];
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int cnt4 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int N = sc.nextInt();
        String s = sc.next();
        //int list = sc.nextInt();
        //String s = String.valueOf(list);
        String[] c = s.split("");
        //String s = sc.next;
        //String [] c = s.split("");
        for (int i = 0; i < N ; i++) {
             switch (c[i]) {
                 case "1":
                       cnt1++;
                       //cnt1 = cnt1 + Integer.parseInt(c[i]);
                       break;
                 case "2":
                       cnt2++;
                       //cnt2 = cnt2 + Integer.parseInt(c[i]);
                       break;
                 case "3":
                        cnt3++;
                        //cnt3 = cnt3 + Integer.parseInt(c[i]);
                        break;
                 case "4":
                        cnt4++;
                        //cnt4 = cnt4 + Integer.parseInt(c[i]);
                        break;
              }
         }
         //System.out.println("cnt1  " + cnt1);
         //System.out.println("cnt2  " + cnt2);
         //System.out.println("cnt3  " + cnt3);
         //System.out.println("cnt4  " + cnt4);
         int[] num = {cnt1,cnt2,cnt3,cnt4};
         int a = 0;
         int b = num[0];
         for (int j = 0; j< num.length;j++){
            a = Math.max(a, num[j]);
            b = Math.min(b, num[j]);
         }
      System.out.println(a + " " + b);
 }
 }