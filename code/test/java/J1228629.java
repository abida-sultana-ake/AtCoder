import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        String[] strMemos = new String[n];
        for (int i = 0; i < n; i++) {
            strMemos[i] = sc.next();
        }
        Arrays.sort(strMemos);
 
        int[][] memos = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] memo = strMemos[i].split("-");
            memos[i][0] = getRoundStart(Integer.valueOf(memo[0]));
            memos[i][1] = getRoundEnd(Integer.valueOf(memo[1]));
        }
 
        List<int[]> unitedMemos = new ArrayList<>();
 
        int preStart = memos[0][0];
        int preEnd = memos[0][1];
 
        for (int i = 1; i < n; i++) {
            if (memos[i][0] >= preStart && memos[i][0] <= preEnd) {
                if (memos[i][1] > preEnd) {
                    preEnd = memos[i][1];
                }
            } else {
                unitedMemos.add(new int[] { preStart, preEnd });
                preStart = memos[i][0];
                preEnd = memos[i][1];
            }
        }
        unitedMemos.add(new int[] { preStart, preEnd });
 
        for (int[] rains : unitedMemos) {
            String start = String.format("%04d", rains[0]);
            String end = String.format("%04d", rains[1]);
            System.out.println(start + "-" + end);
        }
 
        sc.close();
    }
 
    private static int getRoundStart(int val) {
        int result = 0;
 
        if (val % 5 == 0) {
            result = val;
        } else {
            result = val - (val % 5);
        }
 
        return result;
    }
 
    private static int getRoundEnd(int val) {
        int result = 0;
 
        if (val % 5 == 0) {
            result = val;
        } else {
            result = val + (5 - (val % 5));
 
            if (result % 100 == 60) {
                result -= 60;
                result += 100;
            }
        }
 
        return result;
    }
 
}