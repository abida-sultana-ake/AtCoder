import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]),
            K = Integer.parseInt(line[1]);
 
        int paint = K;//first ball: K colors
        for(int n=1;n<N;n++) paint *= (K-1);//the others: K-1 colors
        System.out.println(paint);
    }
}