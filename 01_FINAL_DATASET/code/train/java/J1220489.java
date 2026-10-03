import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main{

    public static boolean like(int n, List<Integer> d_lst){
        while(n > 0){
            int mod = n % 10;
            int q = n / 10;
            if(d_lst.contains(mod)){
                return false;
            }

            if(q == 0){
                break;
            }
            else{
                n = q;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        PrintWriter out = new PrintWriter(System.out);
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());

        List<Integer> d_lst = new ArrayList<>();
        
        for(int i = 0; i < k; i++){
            d_lst.add(Integer.parseInt(sc.next()));
        }

        int cand_n = n;
        while(true){
            if(like(cand_n, d_lst)){
                out.println(cand_n);
                break;
            }
            cand_n++;
        }



        
        out.flush();
        sc.close();

    }
}
