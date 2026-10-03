import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> param = new ArrayList<String>();

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				param.add(sc.nextLine());
			} else {
				param.add(sc.nextLine());
			}
		}
		Method(num, param);
	}
	
	static void Method(ArrayList<Integer> num, ArrayList<String> param) {
		boolean flag = false;
		
		for(int i = 1; i < 4; i++){
			if(param.get(0).charAt(0) != param.get(0).charAt(i)){
				flag = true;
				break;
			}
		}
		if(!flag){
			System.out.println("SAME");	
		} else {
			System.out.println("DIFFERENT");			
		}
	}
}