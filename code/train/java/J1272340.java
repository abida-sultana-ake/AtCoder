import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int en = 0;
            int N = sc.nextInt();
            int nlen2 = (N / 10) % 10; // (N % 100) / 10   //10の位
            int nlen1 = N % 10;                                        //1の位
            int nlen = String.valueOf( N ).length();          // 桁数
            if (nlen == 1) {
              if (nlen1 >= 7) {
                en = 100;
              } else {
                en = N * 15;
              }
            }  
            if (nlen == 2) {  
              if (nlen1 >= 7) {
                switch (nlen2) {
                  case 1:
                    en = 200;
                    break;
                  case 2:
                    en = 300;
                    break;
                  case 3:
                    en = 400;
                    break;
                  case 4:
                    en = 500;
                    break;
                  case 5:
                    en = 600;
                    break;
                } 
              } else {
                 switch (nlen2) {
                  case 1:
                    en = 100;
                    break;
                  case 2:
                    en = 200;
                    break;
                  case 3:
                    en = 300;
                    break;
                  case 4:
                    en = 400;
                    break;
                  case 5:
                    en = 500;
                    break;
              }
              en = en + nlen1 * 15; 
            }
            }
            System.out.println(en);
   }
}