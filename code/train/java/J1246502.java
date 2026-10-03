
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] yosou = new int[4][100000];
	static int[] input_array = new int[100000];

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		String line = sc.next();
		for(int i = 0;i < line.length();i++){
			char ch = line.charAt(i);
			if(ch == 'x')input_array[i] = 1;
		}

		//羊、羊...
		yosou[0][0] =  1;
		yosou[0][1] =  1;
		//羊、狼...
		yosou[1][0] =  1;
		yosou[1][1] = -1;
		//狼、羊...
		yosou[2][0] = -1;
		yosou[2][1] =  1;
		//狼、狼...
		yosou[3][0] = -1;
		yosou[3][1] = -1;

		int yosou_id = -1;
		for(int i = 0;i < 4;i++){
			for(int j = 2;j < N;j++){
				int left1_animal = yosou[i][j-1];
				int left2_animal = yosou[i][j-2];


				if(input_array[j-1] == 0){
					yosou[i][j] = left1_animal * left2_animal;
				}else{
					yosou[i][j] = -left1_animal * left2_animal;
				}
			}

			if(!isCorrect(i, 0))continue;
			if(!isCorrect(i, N-1))continue;
			yosou_id = i;
			break;
		}

		if(yosou_id < 0){
			System.out.println(-1);
		}else{
			for(int i = 0;i < N;i++){
				if(yosou[yosou_id][i] == 1){
					System.out.print("S");
				}else{
					System.out.print("W");
				}
			}
		}
		System.out.println();

		sc.close();
	}

	public static boolean isCorrect(int i,int j){
		int left = j - 1;
		if(left < 0)left += N;
		int right = j + 1;
		if(right >= N) right -= N;

		boolean match = yosou[i][left] == yosou[i][right];

		if(yosou[i][j] == 1){
			if(input_array[j] == 0){
				return match;
			}
			return !match;
		}

		if(input_array[j] == 0){
			return !match;
		}
		return match;
	}
}
