import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//    	long l = System.currentTimeMillis();
        new Main().exec();
//    	long l2 = System.currentTimeMillis();
//    	System.out.println(l2 - l);
    }
    
    public void exec() throws IOException {
        InputUtil in = new InputUtil();
        PrintWriter out = new PrintWriter(System.out);
        String str = in.br.readLine();
        long K = Long.parseLong(str);
        int N = 50;
        long[] a = new long[N];
        Arrays.fill(a, 49);
        long sho = K/N;
        int amari = (int)(K%N);
        for(int i=0; i<N; i++) {
        	if(i<amari){
        		a[i] = 100 - amari + sho;
        	} else {
        		a[i] = 49 - amari + sho;
        	}
        }
    	out.println(N);
    	for(int i=0; i<N; i++) {
    		if(i>0)
    			out.print(" ");
    		out.print(a[i]);
    	}
    	out.println("");
        out.flush();
    }
    
}

class InputUtil {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String[] readStrArray(String delim) throws NumberFormatException, IOException{
    	return br.readLine().split(delim);
    }
    
}