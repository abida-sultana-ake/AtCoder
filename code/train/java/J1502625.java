import java.util.Scanner;


public class Main 
{

	public static void main(String[] args) 
	{
		// TODO 自動生成されたメソッド・スタブ
		
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		
		System.out.println(Main.judge(y));

	}
	
	static String judge(int y)
	{
		String answer ="NO";
		
		if(y%4==0)
		{
			answer ="YES";
		}
		
		if(y%100==0)
		{
			answer ="NO";
		}
		
		if(y%400==0)
		{
			answer ="YES";
		}
		
		return answer;
	}

}