import java.util.ArrayList;
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
		long W = num.get(3);
		int count = 0;

		for(int i = 3; i < num.size(); i++){
			if(num.get(1) <= W && W <= num.get(2)) count++;
			if(i < num.size()-1) W += num.get(i+1);
		}
		System.out.println(count);
	}
}