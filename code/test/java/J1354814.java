import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by takaesumizuki on 2017/06/14.
 */
public class Main {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] str = new int[6];
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(i -> str[i-1] = i);
//        this.printArray(str);
        //30で割ればok
        for(int i = 0; i < n % 30; i++){
//            System.out.println(i + 1 + "回目のループ");
            this.change(str,i);
//            this.printArray(str);
        }
        this.printArray(str);
    }

    void change(int[] str,int n){
        n %= 5;
        int m = n + 1;
        int tmp = str[n];
        str[n] = str[m];
        str[m] = tmp;
    }
    void printArray(int[] str){
        for(int i = 0; i < str.length; i++){
            System.out.print(str[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().run();
    }

}

