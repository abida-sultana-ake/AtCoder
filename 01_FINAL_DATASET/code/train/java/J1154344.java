import java.awt.List;
import java.util.*;
public class Main {
	static int modNum = 1000000007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		for(int i=1;i<=a*2;i++){
//			int b = sc.nextInt();
//			list.add(b);
//		}

		if(a<1200){
			System.out.println("ABC");
		}else{
			System.out.println("ARC");
		}
		sc.close();
	}
}