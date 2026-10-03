import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String[] ar = str.split("");
		List<String> list=Arrays.asList(ar);
		boolean flg = false;
		
//		for(int i=0; i<list.size()-1; i++){
//			System.out.println("true");
//			String tmp = list.get(i);
//			list.remove(i);
//			flg = list.contains(tmp);
//			if(flg){
//				break;
//			}
//		}
//		
		
		
		
		
		for(int i=0; i<ar.length; i++){
			for (int j=i+1; j<ar.length; j++){
//				System.out.println("ar["+i+"]="+ar[i]);
//				System.out.println("ar["+j+"]="+ar[j]);
				if(ar[i].equals(ar[j])){
//					System.out.println("true");
					flg = true;
					break;
				}
			}
		}
		
		if(flg){
			System.out.println("no");
		}
		else {
			System.out.println("yes");
		}
		
		
	}

}
