import java.util.Scanner;

public class Main {

	static String at ="atcoder";
	static int atlen = at.length();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();

		for(int i = 0;i < str1.length(); i++){
			if(str1.charAt(i) != str2.charAt(i)){
				if(str1.charAt(i) == '@'){
					if(!match(str2.charAt(i))){
						System.out.println(("You will lose"));
						return;
					}
				}else if(str2.charAt(i) == '@'){
					if(!match(str1.charAt(i))){
						System.out.println(("You will lose"));
						return;
					}
				}else{
					System.out.println(("You will lose"));
					return;
				}
			}
		}
		System.out.println(("You can win"));

	}
	public static boolean match(char a){
		for(int i = 0; i < atlen; i++){
			if(a == at.charAt(i)){
				return true;
			}
		}
		return false;
	}

}
