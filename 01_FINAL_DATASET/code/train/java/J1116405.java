
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		long s = scanner.nextLong();
		long c = scanner.nextLong();
		long ans = 0;
		
		if(2 * s <= c){
			// まず、sピース全て使える場合。
			ans += s;
			c -= s * 2;
			s = 0;
			ans += c / 4;
		} else {
			// sピースが余る
			ans += c / 2;
		}
		
		System.out.println(ans);
	}
}