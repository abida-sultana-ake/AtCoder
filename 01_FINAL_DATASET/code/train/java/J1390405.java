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
		ArrayList<String> answer = new ArrayList<String>();
		int count = 0;

		answer.add(param.get(0).substring(0, 1));
		count = 1;
		
		for (int i = 1; i < param.get(0).length(); i++) {
			if (answer.get(answer.size() - 1).equals(param.get(0).substring(i, i + 1))) {
				count++;
			} else {
				answer.add(String.valueOf(count));
				answer.add(param.get(0).substring(i, i + 1));
				count = 1;
			}
		}
		answer.add(String.valueOf(count));
		for (String output : answer) {
			System.out.print(output);
		}
		System.out.println();
	}
}