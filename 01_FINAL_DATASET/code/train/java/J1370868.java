import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Long> num = new ArrayList<Long>();
		ArrayList<String> param = new ArrayList<String>();

		while (sc.hasNext()) {
			if(sc.hasNextInt()){
				num.add(sc.nextLong());
			} else {
				param.add(sc.nextLine());
			}
		}
		Method(num,param);
	}

	static void Method(ArrayList<Long> num, ArrayList<String> param) {

		//ArrayList<Long> numClone = (ArrayList<Long>) num.clone();


		Collections.sort(num,Comparator.reverseOrder());
		System.out.println(num.get(1));

	}
}