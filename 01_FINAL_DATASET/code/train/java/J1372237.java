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

		if(num.get(0) == 100){
			System.out.println("Perfect");
		} else if(num.get(0) >= 90){
			System.out.println("Great");
		} else if(num.get(0) >= 60){
			System.out.println("Good");
		} else {
			System.out.println("Bad");
		}
	}
}