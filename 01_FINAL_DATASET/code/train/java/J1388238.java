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

		int target = (int) Math.sqrt((int)num.get(0));
		int result = 0;
		int answer = 999999999;

		for(int i = -100; i < 100; i++){
			for(int j = -100; j < 100; j++){
				if(num.get(0) - (target + i) * (target + j) < 0) break;
				result = (num.get(0) - (target + i) * (target + j) + Math.abs((target + i) - (target + j)));
				if(answer > result) answer = result;
			}
		}
		System.out.println(answer);
	}
}