import java.util.*;
public class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(isURUU(s.nextInt())?"YES":"NO");
	}

	static boolean isURUU(int y) {
		return y%4==0&&(y%100!=0||y%400==0);
	}
}