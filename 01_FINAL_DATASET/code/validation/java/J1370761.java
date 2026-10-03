import java.io.UnsupportedEncodingException;
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

	static void Method(ArrayList<Long> num, ArrayList<String> param) throws UnsupportedEncodingException{

		byte[] a = ("A"+param.get(0)).getBytes("US-ASCII");
			System.out.println(a[1] - a[0] +1);
	}
}