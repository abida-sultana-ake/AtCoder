import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> param = new ArrayList<String>();

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				num.add(sc.nextInt());
			} else {
				param.add(sc.nextLine());
			}
		}
		Method(num, param);
	}
	
	static void Method(ArrayList<Integer> num, ArrayList<String> param) {

		if(num.get(0) < num.get(1)){
			System.out.println("Better");
		} else {
			System.out.println("Worse");	
		}
	}
}