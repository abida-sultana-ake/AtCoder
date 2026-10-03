import java.util.Scanner;

public class Main {
	private static final String format = "ABCDE";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String x = scanner.next();
		for(int i=0;i<format.length();i++){
			if(x.equals(String.valueOf(format.charAt(i)))){
				System.out.println(i+1);
				break;
			}
		}
	}

}
