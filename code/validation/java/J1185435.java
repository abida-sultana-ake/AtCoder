
import java.util.Scanner;

public class Main {
	public static void main(String a[])
	{
		Scanner sc= new Scanner(System.in);

		boolean tmp = true, tmp2 = true;

		if (sc.next().equals("D"))
		{
			tmp = false;
			//System.out.println(tmp);
		}

		if (sc.next().equals("D"))
		{
			tmp2 = false;
			//System.out.println(tmp2);
		}

		sc.close();

		if (!tmp)
		{
			tmp2 = !tmp2;
		}

		if (tmp2)
		{
			System.out.println("H");
		}
		else
		{
			System.out.println("D");
		}
	}
}
