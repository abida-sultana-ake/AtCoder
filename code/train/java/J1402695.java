import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner cin=new Scanner(System.in);
		cin.nextLine();
		String[] answers = cin.nextLine().split(""); // 2行目のデータ
		int[] count = new int[4]; // 回答の数をカウント

		for( int i=0 ; i<answers.length ; i++ ){
			count[Integer.parseInt(answers[i])-1]++;
		}

		Arrays.sort(count);
		System.out.println(count[3] + " " + count[0]);

		cin.close();
	}

}
