
import java.util.*;
public class Main {
    static public Scanner read;
    static int a,b,n;
    public static void main(String[] args){
        read = new Scanner(System.in);
        a = read.nextInt();
        b = read.nextInt();
        n = a + b;
        if (b >= a)
            System.out.print("Impossible");
        else{
            String ans = "";
            int honest = getHonest();
            for (int i = 0; i < n; i++){
                ans += q(honest, i) ? '1' : '0';
            }
            System.out.print("! " + ans);
        }
    }

    static int getHonest() {
        int dis = b + 1 ;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(list.isEmpty()) {
                list.push(i);
            }
            else {
                if(q(list.peek(), i)) {
                    list.push(i);
                }
                else {
                    list.pop();
                    dis--;
                }
            }
            if(list.size() >= dis)
                return list.pop();
        }
        return -1;
    }

    static boolean q(int a, int b){
        System.out.println("? " + a + " " + b);
        return read.next().equals("Y");
    }
}