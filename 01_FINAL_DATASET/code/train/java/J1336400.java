import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 文字の入力
		String a = sc.next();
                for (int i=0; i<a.length()-1; i++){
                     for (int j=i+1; j<a.length();j++){
                          if (a.charAt(i) == a.charAt(j) ){
                               System.out.println("no");
                               return;
                          }
                     }
                }
		// 出力
		System.out.println("yes");
	}
}