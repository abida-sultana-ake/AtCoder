import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		BigDecimal N, M;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext())
		{
			N = scanner.nextBigDecimal();
			M = scanner.nextBigDecimal();
			if(N.compareTo(M) == 0) 
				System.out.println("EQUAL");
			else if(N.compareTo(M) > 0)
				System.out.println("GREATER");
			else 
				System.out.println("LESS");
		}
		
	}
}
