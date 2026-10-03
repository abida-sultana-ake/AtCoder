import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String A = s.nextLine();
		s.close();

		if(A.equals("a")) {
			System.out.println(-1);
			return;
		} else {
			System.out.println("a");
			return;
		}

//		char[] aMoji = A.toCharArray();
//		boolean ok = false;
//		for(int i = 0; i < aMoji.length; i++) {
//			if(aMoji[i] != 'a') {
//				aMoji[i]--;
//				ok = true;
//				break;
//			}
//		}
//
//		if(ok) {
//			String ans = String.valueOf(aMoji);
//			System.out.println(ans);
//		} else {
//			String ans = String.valueOf(aMoji).substring(0, aMoji.length-1);
//			System.out.println(ans);
//		}
	}

}