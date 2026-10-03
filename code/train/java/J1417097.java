

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int row,col,k;
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        row = Integer.parseInt(tmp[0]);
        col = Integer.parseInt(tmp[1]);
        k = Integer.parseInt(tmp[2]) - 1;
        boolean[][] board = new boolean[row][col];
        String input;
        for(int r = 0;r < row;r++) {
            input = sc.nextLine();
            for(int c = 0;c < col;c++)
                board[r][c] = input.charAt(c) == 'o';
        }
        int counter = 0;
        boolean flag;
        for(int r = k;r < board.length - k;r++)
            for(int c = k ;c < board[r].length- k ;c++)
            {
                if(board[r][c])
                {
                    flag = true;
                    for(int i = r - k;i<=r+k;i++) {
                        if (!test(board[i], c, k - Math.abs(i - r)))
                        {
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        counter++;
                }
                else
                    c += k;
            }
        System.out.println(counter);
    }
    private static boolean test(boolean[] row,int center,int width)
    {
        for(int i = center - width;i <= center + width;i++)
            if(!row[i])
                return false;
        return true;
    }
}
