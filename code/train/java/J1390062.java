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
		int time = num.get(0) * 60 + num.get(1);
		double timeOne = time * 0.5 % 360;
		double timeTwo = time * 6 % 360;

		if(Math.abs(timeOne - timeTwo) < 180){
			System.out.println(Math.abs(timeOne - timeTwo));
		} else {
			System.out.println(360 - Math.abs(timeOne - timeTwo));
		}
	}
}