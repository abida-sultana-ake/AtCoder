import java.util.Scanner;
public class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		double
		a=s.nextDouble(),
		b=s.nextDouble(),
		c=s.nextDouble(),
		d=s.nextDouble(),

		rT=b/a,rA=d/c;

		if(rT>rA)
			System.out.println("TAKAHASHI");
		else if(rT<rA)
			System.out.println("AOKI");
		else
			System.out.println("DRAW");
	}
}
