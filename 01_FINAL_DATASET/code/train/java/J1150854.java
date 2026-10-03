

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int n = scan.nextInt();
		List<Integer>  createTime = new ArrayList<>();;
		for(int i = 0; i < n; i++) {
			createTime.add(scan.nextInt());
		}

		int m = scan.nextInt();
		int [] comeTime = new int[m];

		for(int i = 0; i < m; i++){
			comeTime[i] = scan.nextInt();
		}

		scan.close();

		//作る数よりお客様の数が多かった場合
		if(m > n ){
			System.out.println("no");
			return;

		}



		int tmp = 0;
		//売れるか判定
		for(int i = 0; i < m; i ++){

			for(int j = t; j >= 0; j--){
				tmp = createTime.indexOf(comeTime[i]-j);
				if(tmp != -1 ){
					createTime.remove(tmp);
					break;

				}else if(j == 0) {
					System.out.println("no");
					return;
				}


			}




		}




		System.out.println("yes");



	}

}
