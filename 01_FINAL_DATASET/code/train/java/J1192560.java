import java.util.Calendar;
import java.util.Scanner;

public class Main{

	static Scanner s=new Scanner(System.in);

	public static void main(String __[]){
		input();
		solve();
	}

	static Calendar cl = Calendar.getInstance();
	private static void input(){
		s.useDelimiter("[^0-9]");
		cl.set(Calendar.YEAR,s.nextInt());
		cl.set(Calendar.MONTH,s.nextInt()-1);
		cl.set(Calendar.DAY_OF_MONTH,s.nextInt());
		cl.setLenient(true);
	}
	private static void solve(){
		while(cl.get(Calendar.YEAR)
				%((cl.get(Calendar.MONTH)+1)*cl.get(Calendar.DAY_OF_MONTH))
				!=0) {
			cl.add(Calendar.DAY_OF_YEAR,1);
			//System.out.printf("%d/%d/%d\n",cl.get(Calendar.YEAR),cl.get(Calendar.MONTH)+1,cl.get(Calendar.DAY_OF_MONTH));
		}
		System.out.printf("%04d/%02d/%02d\n",
				cl.get(Calendar.YEAR),
				cl.get(Calendar.MONTH)+1,
				cl.get(Calendar.DAY_OF_MONTH));
	}
}