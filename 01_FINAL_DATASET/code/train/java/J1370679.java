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
		Method(num);
	}

	static void Method(ArrayList<Long> num){
		
		System.out.println(num.get(0)*2);
	}
}