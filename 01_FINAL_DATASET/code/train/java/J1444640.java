import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		int b = sc.nextInt();
	
        // 出力
        if(a%3 == 0){
            System.out.println("Possible");
        }else if(b%3 == 0){
            System.out.println("Possible");
        }else if((a+b)%3 == 0){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }
	}
}