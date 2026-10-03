import java.math.BigDecimal;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double deg = scanner.nextInt(), dis = scanner.nextInt();
		int w = convertDis(dis);
		String dir = "";
		if(w == 0){
			dir = "C";
		}else{
			dir = convertDeg(deg);
		}
		System.out.println(dir + " " + w);
	}
 
	public static String convertDeg(double m){
		if(112.5 <= m && m < 337.5){
			return "NNE";
		}else if(337.5 <= m && m < 562.5){
			return "NE";
		}else if(562.5 <= m && m < 787.5){
			return "ENE";
		}else if(787.5 <= m && m < 1012.5){
			return "E";
		}else if(1012.5 <= m && m < 1237.5){
			return "ESE";
		}else if(1237.5 <= m && m < 1462.5){
			return "SE";
		}else if(1462.5 <= m && m < 1687.5){
			return "SSE";
		}else if(1687.5 <= m && m < 1912.5){
			return "S";
		}else if(1912.5 <= m && m < 2137.5){
			return "SSW";
		}else if(2137.5 <= m && m < 2362.5){
			return "SW";
		}else if(2362.5 <= m && m < 2587.5){
			return "WSW";
		}else if(2587.5 <= m && m < 2812.5){
			return "W";
		}else if(2812.5 <= m && m < 3037.5){
			return "WNW";
		}else if(3037.5 <= m && m < 3262.5){
			return "NW";
		}else if(3262.5 <= m && m < 3487.5){
			return "NNW";
		}else{
			return "N";
		}
 
	}
 
	public static int convertDis(double n){
		double result = n / 60;
		
		BigDecimal bi = new BigDecimal(String.valueOf(result));
		double k1 = bi.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
		
 
		if(0 <= k1 && k1 <= 0.2){
			return 0;
		}else if(0.3 <= k1 && k1 <= 1.5){
			return 1;
		}else if(1.6 <= k1 && k1 <= 3.3){
			return 2;
		}else if(3.4 <= k1 && k1 <= 5.4){
			return 3;
		}else if(5.5 <= k1 && k1 <= 7.9){
			return 4;
		}else if(8.0 <= k1 && k1 <= 10.7){
			return 5;
		}else if(10.8 <= k1 && k1 <= 13.8){
			return 6;
		}else if(13.9 <= k1 && k1 <= 17.1){
			return 7;
		}else if(17.2 <= k1 && k1 <= 20.7){
			return 8;
		}else if(20.8 <= k1 && k1 <= 24.4){
			return 9;
		}else if(24.5 <= k1 && k1 <= 28.4){
			return 10;
		}else if(28.5 <= k1 && k1 <= 32.6){
			return 11;
		}else if(32.7 <= k1){
			return 12;
		}
		return 0;
	}
}