import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int masukazu = Integer.parseInt(scn.nextLine());
		char[][] input = new char[masukazu][masukazu];
		String line = "";

		//配列に格納
		for(int i = 0; i < masukazu; i++){
			line = scn.nextLine();
			for(int j = 0; j < masukazu; j++){
				//一文字ずついれる
				input[i][j] = line.charAt(j);
			}
		}
		scn.close();

		//表示
//		for(char[] outer : input){
//			for(char c : outer){
//				System.out.print(c);
//			}
//			System.out.println();
//		}
//
//		System.out.println();

		//回転して表示
				for(int i = 0; i < masukazu; i++){
					for(int j = masukazu - 1; j >= 0; j--){
						//一文字ずついれる
						System.out.print(input[j][i]);
					}
					System.out.println();
				}

	}

}
