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
		ArrayList<Long> fib = new ArrayList<Long>();
		
		fib.add(0l);
		fib.add(0l);
		fib.add(1l);
		
		for(int i = 3; i <num.get(0); i++){
			fib.add((fib.get(i-1) + fib.get(i-2) + fib.get(i-3)) % 10007);
		}
		System.out.println(fib.get(num.get(0)-1));
	}
}