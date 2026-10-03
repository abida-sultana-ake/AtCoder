import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static final Scanner s=new Scanner(System.in);
	public static void main(String[] __){
		System.out.println(Arrays.stream(s.next().split("\\+")).filter(o->!o.contains("0")).count());
	}
}
