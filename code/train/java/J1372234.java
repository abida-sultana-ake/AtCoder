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

		int count = 0;
		int count2 = 0;
		
		for(int i = 0; i < num.size(); i++){
			if(num.get(0) == num.get(i)) count++;
		}
		for(int i = 0; i < num.size(); i++){
			if(num.get(1) == num.get(i)) count2++;
		}
		
		if(count == 1){
			System.out.println(num.get(0));
		} else if(count2 == 1){
			System.out.println(num.get(1));
		} else {
			System.out.println(num.get(2));
		}
	}
}