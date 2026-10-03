
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		abc015_3(br);
	}
	
	private static void abc015_1(BufferedReader br) throws IOException {
		String[] a = new String[2];
        a[0] = br.readLine();
        a[1] = br.readLine();
        System.out.println(a[0].length() > a[1].length() ? a[0] : a[1]);
	}
	
	private static void abc015_2(BufferedReader br) throws IOException {
		int number = Integer.parseInt(br.readLine());
		String[] target = br.readLine().split(" ");
		float sum = 0;
		float targetNum = 0;
		for(int i = 0;i < number;i++){
			int n = Integer.parseInt(target[i]);
			if(n > 0){
				sum += n;
				targetNum++;
			}
		}
        System.out.println(Math.round(Math.ceil(sum/targetNum)));
	}
	
	static int[][] targetNum;
	static int optionNum;
	static int questionNum;
	
	private static void abc015_3(BufferedReader br) throws IOException {
		String[] target = br.readLine().split(" ");
		questionNum = Integer.parseInt(target[0]);
		optionNum = Integer.parseInt(target[1]);
		targetNum = new int[questionNum][optionNum];
		for(int i = 0;i < questionNum;i++){
			String[] questions = br.readLine().split(" ");
			for(int n=0;n<optionNum;n++){
				targetNum[i][n] = Integer.parseInt(questions[n]);
			}
		}
		if(cross(0,0)){
			System.out.println("Found");
		}else{
			System.out.println("Nothing");
		}
	}
	
	private static boolean cross(int depth, int beforeValue) {
		if(depth == questionNum){
			return beforeValue == 0;
		}
		for(int i =0;i<optionNum;i++){
			if(cross(depth+1,targetNum[depth][i]^beforeValue)) return true;
		}
		return false;
	}
}
