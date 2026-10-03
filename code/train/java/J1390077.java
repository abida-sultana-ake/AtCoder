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
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int countE = 0;
		int countF = 0;
		
		for(int i = 0; i < param.get(0).length(); i++){
			if(param.get(0).charAt(i) == 'A') countA++;
			if(param.get(0).charAt(i) == 'B') countB++;
			if(param.get(0).charAt(i) == 'C') countC++;
			if(param.get(0).charAt(i) == 'D') countD++;
			if(param.get(0).charAt(i) == 'E') countE++;
			if(param.get(0).charAt(i) == 'F') countF++;
		}
		System.out.println(countA + " " + countB + " " + countC + " " + countD + " " + countE + " " + countF); 
	}
}