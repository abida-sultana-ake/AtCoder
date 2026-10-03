import java.util.Scanner;
public class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		char[] c = s.next().toCharArray();
		int sum=0;
		for(int i=0;i<c.length;i++) {
			sum+=c[i]-'0';
		}
		System.out.println(sum);
	}
}
