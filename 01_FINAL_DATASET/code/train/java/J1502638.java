import java.util.Calendar;
import java.util.Scanner;


public class Main 
{

	public static void main(String[] args) 
	{
		// TODO 自動生成されたメソッド・スタブ
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		String[] ymd = input.split("/", 0);
		
		int y = Integer.parseInt(ymd[0]);
		int m = Integer.parseInt(ymd[1]);
		int d = Integer.parseInt(ymd[2]);
		
		System.out.println(Main.judge(y,m,d));

	}
	
	static String judge(int y,int m,int d)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(y,(m-1),d);
		
		String answer ="";
		for(;;)
		{
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH)+1;
			int day = calendar.get(Calendar.DATE);
//			System.out.println("cal:"+ year +"/"+ (month+1) +"/"+ day);
			
			if((year%(month*day))==0)
			{
				
				answer = year +"/"+ ((month>=10)? month : "0"+month)  +"/"+ ((day>=10)? day : "0"+day);
				break;
			}
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return answer;
	}

}
