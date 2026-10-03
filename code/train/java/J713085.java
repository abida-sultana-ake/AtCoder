import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 自分の得意な言語で
        // "Hello World" と出力するコードを書いてみよう！
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int k = 0;
//        System.out.println(line.substring(0, 1));
    	for (int i = 0 ;i < line.length();++i){ 
    		String str = line.substring(i, i+1);

        try {
        	if ( k > 0  ){
        		k = 10*k+Integer.parseInt(str);
        	}else{
        		k = Integer.parseInt(str); 
        	}
        }catch(Exception e){
//        	  System.out.println("配");
        }
    	}
        System.out.println(k);
        
//        int i = Integer.parseInt(line);
    }
}