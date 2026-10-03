import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		boolean isLeapYear;
		if(year%400 == 0){
			isLeapYear = true;
		}else if(year%100 == 0){
			isLeapYear = false;
		}else if(year%4 == 0){
			isLeapYear = true;
		}else{
			isLeapYear = false;
		}
		if(isLeapYear){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}