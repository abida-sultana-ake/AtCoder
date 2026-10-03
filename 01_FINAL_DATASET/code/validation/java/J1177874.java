import java.util.*;
public class Main {
    private static Scanner sc=new Scanner(System.in);
    private static ArrayList<Character> charArray=new ArrayList<Character>();
    public static void main(String[] args){
        int sx=sc.nextInt();
        int sy=sc.nextInt();
        int tx=sc.nextInt();
        int ty=sc.nextInt();
       up(ty-sy);
       right(tx-sx);
       down(ty-sy);
       left(tx-sx+1);
       up(ty-sy+1);
       right(tx-sx+1);
       down(1);
       right(1);
       down(ty-sy+1);
       left(tx-sx+1);
       up(1);
       for(int i=0;i<charArray.size();i++) System.out.print(charArray.get(i));
       System.out.println("");
    }
    private static void up(int x){
        for(int i=0;i<x;i++) charArray.add('U');
    }
    private static void down(int x){
        for(int i=0;i<x;i++) charArray.add('D');
    }
    private static void right(int x){
        for(int i=0;i<x;i++) charArray.add('R');
    }
    private static void left(int x){
        for(int i=0;i<x;i++) charArray.add('L');
    }
}