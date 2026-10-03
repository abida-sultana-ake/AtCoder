import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> param = new ArrayList<String>();
		int system = 0; // 文字の空白区切り　0:ON　1:OFF

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				num.add(sc.nextInt());
			} else {
				if(system==0) param.add(sc.next());
				if(system==1) param.add(sc.nextLine());
			}
		}
		Method(num, param);
	}

	static void Method(ArrayList<Integer> num, ArrayList<String> param) {
		boolean flag = false;
		String target = "";
		
		param = new ArrayList<String>(Arrays.asList(param.get(0).split("")));
		int size = param.size();

		for(int i = 0; i < size; i++){
			target = param.get(0);
			param.remove(0);
			if(param.contains(target)) flag = true;
		}
		
		if(!flag){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}