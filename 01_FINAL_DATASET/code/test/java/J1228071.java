import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		s.nextLine();
		int i=0;
		for(String v:s.nextLine().split("[ \\.]")) {
			if(v.matches("^(Takahashikun|TAKAHASHIKUN|takahashikun)$"))
				i++;
		}
		System.out.println(i);
	}
}
