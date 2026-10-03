import java.io.IOException;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		//入力値を読み込む
		int a = scanner.nextInt();
		String op = scanner.next();
		int b = scanner.nextInt();
		
		//opが「+」か「-」か判定し計算結果を出力
		if(op.equals("+")){
			System.out.println(a+b);
		}else{
			System.out.println(a-b);
		}
	}
}