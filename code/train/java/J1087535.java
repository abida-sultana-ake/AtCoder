import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
 
class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		String s = br.readLine();
 
		BigDecimal num = new BigDecimal(s);
/*
		if (num.compareTo(new BigDecimal("6")) <= 0) {
			System.out.println("1");
		} else if (num.compareTo(new BigDecimal("11")) <= 0) {
			System.out.println("2");
		} else*/ if ((num.remainder(new BigDecimal("11"))).compareTo(new BigDecimal("0")) != 0) {
 
			if ((num.remainder(new BigDecimal("11"))).compareTo(new BigDecimal("6")) > 0) {
				System.out.println(num.divide(new BigDecimal("11"), 0,BigDecimal.ROUND_FLOOR)
						.multiply(new BigDecimal("2")).add(new BigDecimal("2")));
			} else {
				System.out.println(num.divide(new BigDecimal("11"), 0,BigDecimal.ROUND_FLOOR)
						.multiply(new BigDecimal("2")).add(new BigDecimal("1")));
 
			}
		} else {
			System.out.println(num.divide(new BigDecimal("11"),0,BigDecimal.ROUND_FLOOR).multiply(new BigDecimal("2")));
		}
	}
 
}