import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ena000078
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> brList1 = new ArrayList<>();
        boolean[] ship = new boolean[N+1];
                
        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b == N){
                brList1.add(a);
            }else if(a == 1){
                ship[b] = true;
            }
        }
        
        String pos = "IMPOSSIBLE";
        for(int tBr1 : brList1){
            if (ship[tBr1]){
                pos = "POSSIBLE";
                break;
            }
        }
        System.out.println(pos);
    }
    
}
