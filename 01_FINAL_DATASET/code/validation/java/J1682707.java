import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
	static Scanner sc;
	static char[][] map;
	static int H, W;

	public static void main(String[] args) throws Exception {
		//InputStream in = new FileInputStream("src/input.txt");
		InputStream in = System.in;

		sc = new Scanner(in);

		H = sc.nextInt();
		W = sc.nextInt();

		map = new char[H][W];
		for(int h = 0; h < H; h++){
			String line = sc.next();
			for(int w = 0; w < W; w++){
				map[h][w] = line.charAt(w);
			}
		}

		for(int h = 0; h < H; h++){
			for(int w = 0; w < W; w++){
				if(map[h][w] == '#'){
					System.out.print("#");
				}else{
					System.out.print(count(h, w));
				}
			}
			System.out.println();
		}
	}

	public static int count(int h, int w){
		int answer = 0;

		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				try{
					if(map[h+i][w+j] == '#'){
						answer++;
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		return answer;
	}
}