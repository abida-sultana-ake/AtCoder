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
		int total = 0;
		int count = 0;
		int tyouka = 0;

		for(int i = 1; i <= num.get(0); i++){
			total += num.get(i);
		}
		if(total % num.get(0) != 0){
			System.out.println(-1);
			System.exit(0);
		}
		
		int bar = total / num.get(0);
		for(int i = 1; i <= num.get(0); i++){
			tyouka = num.get(i) - bar + tyouka;
			if(tyouka != 0) count++;
		}
		System.out.println(count);
	}
}