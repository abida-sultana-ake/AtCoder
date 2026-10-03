import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> param = new ArrayList<String>();
		int system = 0; // 文字の空白区切り 0:ON 1:OFF

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				num.add(sc.nextInt());
			} else {
				if (system == 0)
					param.add(sc.next());
				if (system == 1)
					param.add(sc.nextLine());
			}
		}
		Method(num, param);
	}

	static void Method(ArrayList<Integer> num, ArrayList<String> param) {
		int cheak = 0;

		if(num.get(0) < 2){
			if(param.get(0).charAt(0) == 'b'){
				System.out.println(0);
			} else {
				System.out.println(-1);
			}
			System.exit(0);
		}
		if(num.get(0) == 2){
			System.out.println(-1);
			System.exit(0);
		}

		cheak = num.get(0) / 2;
		if(cheak % 3 == 1){
			if(param.get(0).charAt(0) == 'a' && param.get(0).charAt(num.get(0)-1) == 'c' && param.get(0).charAt((num.get(0)-1) / 2) == 'b'){
				System.out.println(cheak);
			} else {
				System.out.println(-1);
			}
		}
		if(cheak % 3 == 2){
			if(param.get(0).charAt(0) == 'c' && param.get(0).charAt(num.get(0)-1) == 'a' && param.get(0).charAt((num.get(0)-1) / 2) == 'b'){
				System.out.println(cheak);
			} else {
				System.out.println(-1);
			}
		}
		if(cheak % 3 == 0){
			if(param.get(0).charAt(0) == 'b' && param.get(0).charAt(num.get(0)-1) == 'b' && param.get(0).charAt((num.get(0)-1) / 2) == 'b'){
				System.out.println(cheak);
			} else {
				System.out.println(-1);
			}
		}

	}
}