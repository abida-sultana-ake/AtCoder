import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        Scanner sc = new Scanner(System.in);
		// 整数の入力
		String n = sc.next();
		int size = n.length();
		
		int count = 0;
		int index = 0;
		int s = 0;
		while(true){
		    
		    index = n.indexOf("p",s);
		    
		    if(index != -1){
		        s = index +1;
		        count++;
		    }else{
		        break;
		    }
		    
		}
		int max = size/2;
		
				// 出力
		System.out.println(max-count);
    }
}
