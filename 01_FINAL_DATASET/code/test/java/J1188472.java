//package abc032a;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, n, ans = 0;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		for(int i = n; true; i++)
		{
			if((i % a ==0) &&(i % b == 0))
			{
				ans = i;
				break;
			}
	
		}
		System.out.println(ans);

	}
}