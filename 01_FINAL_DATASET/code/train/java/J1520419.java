import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			String N = input.next();
			
			if(isPalindrom(N)){
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}
	
	private static boolean isPalindrom(String s){
		for(int i = 0, j = s.length() -1; i < j; ++i, --j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
			
		return true;
	}

}
