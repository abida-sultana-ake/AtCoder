import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

public class Main {

		public static void main(String[] args){
			
			Scanner sc = new Scanner(System.in);

			String str = sc.next();

			StringBuilder result = new StringBuilder();

			//インデックスは0からスタートするので，奇数番目の文字は偶数のインデックスになる
		    for(int i = 0; i < str.length(); i += 2){
		        result.append(str.charAt(i));
		    }
		    System.out.println(result);

		}
}
