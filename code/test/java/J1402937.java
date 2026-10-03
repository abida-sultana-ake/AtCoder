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
		boolean fast = false;
		
		for(int i = 2; i < num.size(); i++){
			total += num.get(1);
			if(num.get(i-1) + num.get(1) - num.get(i) > 0 && fast){
				total -= num.get(1) - (num.get(i) + num.get(1) - (num.get(i-1) + num.get(1)));
			}
			fast = true;
		}
		System.out.println(total);
	}
}