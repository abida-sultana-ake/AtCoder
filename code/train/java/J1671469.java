
import javax.xml.crypto.Data;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        //入力
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        */
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();


        // 出力
        if(B - A <= 0){
            System.out.println("delicious");
        }
        else if(B - A <= X){
            System.out.println("safe");
        }
        else{
            System.out.println(("dangerous"));
        }
    }
}