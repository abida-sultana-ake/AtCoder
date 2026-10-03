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
		boolean cheak = false;

		for (int i = 0; i < param.get(0).length(); i++) {
			if (param.get(0).charAt(i) != param.get(1).charAt(i)) {
				if (param.get(0).charAt(i) == '@') {
					if (param.get(1).charAt(i) != 'a' && param.get(1).charAt(i) != 't' && param.get(1).charAt(i) != 'c'
							&& param.get(1).charAt(i) != 'o' && param.get(1).charAt(i) != 'd'
							&& param.get(1).charAt(i) != 'e' && param.get(1).charAt(i) != 'r')
						cheak = true;
				}
				if (param.get(1).charAt(i) == '@') {
					if (param.get(0).charAt(i) != 'a' && param.get(0).charAt(i) != 't' && param.get(0).charAt(i) != 'c'
							&& param.get(0).charAt(i) != 'o' && param.get(0).charAt(i) != 'd'
							&& param.get(0).charAt(i) != 'e' && param.get(0).charAt(i) != 'r')
						cheak = true;
				}
				if(param.get(0).charAt(i) != '@' && param.get(1).charAt(i) != '@') cheak = true;
			}
		}
		if(!cheak){
			System.out.println("You can win");
		} else {
			System.out.println("You will lose");
		}
	}
}