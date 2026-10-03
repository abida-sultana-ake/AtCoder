import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        String T = scanner.next();
        
        if(poyo(S,T)){
        	System.out.println("You can win");
        }
        else{
        	System.out.println("You will lose");
        }
	}
    public static boolean poyo(String S, String T){
     	int length = S.length();
       	for(int i = 0; i < length; i++){
        	char x = S.charAt(i);
        	char y = T.charAt(i);
            if((x != y && x != '@' && y != '@') || 
                    (x == '@' && "atcoder@".indexOf(y) == -1) ||
                    (y == '@' && "atcoder@".indexOf(x) == -1)) {
            	return false;
            }
        }
        return true;
                     	
    }
}