import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		double answer = 0;
		num.remove(0);
		
		Collections.sort(num, Comparator.reverseOrder());
		for(int i = 0; i < num.size(); i++){
			if(i % 2 == 0) answer += num.get(i) * num.get(i);
			if(i % 2 == 1) answer -= num.get(i) * num.get(i);
		}
		System.out.println(answer * Math.PI);
	}
}