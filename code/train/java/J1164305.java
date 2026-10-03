import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//配列の宣言
		String[][]bord = new String[4][4];
		//出力用の配列の宣言
		String[][]change = new String[4][4];
		//配列への整数の入力
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4;j++)
			{
			bord[i][j]=	sc.next();
			}
		}
		//１８０度変換
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4;j++)
			{
			change[3-i][3-j] = bord[i][j];
			}
		}
		// 出力
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4;j++)
			{
				System.out.print(change[i][j] + " ");
			}
			System.out.println();
		}

	
	}
}