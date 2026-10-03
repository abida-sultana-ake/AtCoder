import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		// スペース区切りの整数の入力
		int b = sc.nextInt();
		int c = sc.nextInt();
		ArrayList<Integer> sam = new ArrayList<Integer>();
		sam.add(a);
		sam.add(b);
		sam.add(c);
		Collections.sort(sam);
//		for(int i =0;i<sam.size();i++){
//			System.out.println(sam.get(i));
//		}
		if(sam.get(2)==sam.get(1)+sam.get(0)){
			System.out.println("Yes");
		}else System.out.println("No");
		sc.close();
	}
}
