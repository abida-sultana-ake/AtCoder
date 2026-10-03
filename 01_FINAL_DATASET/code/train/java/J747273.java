import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//入力
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N+1];
		for(int i=0; i<N; i++){
			nums[i] = sc.nextInt();
		}
		nums[N] = -1;
		sc.close();
		
		//計算
		long count = 0;
		long tmpCount = 1;
		for(int i=0; i<N; i++){
			if(nums[i]<nums[i+1]){
				tmpCount++;
			}else{
				count += tmpCount*(tmpCount+1)/2;
				tmpCount = 1;
			}
		}
		
		//出力
		System.out.println(count);		
		
	}
}