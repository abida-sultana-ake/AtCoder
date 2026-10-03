import java.util.Scanner;

public class Main {
	
	private static String str;

	public static void main(String[] args) {
		
		//System.out.println("001_B");
		
		Scanner sc = new Scanner( System.in );
		double dir = sc.nextDouble();
		double speed = sc.nextInt();
		
		
		str_dir( dir );
		int wind = speed_b(speed);
			
		System.out.println( str + " " + wind );

	}
	
	private static int speed_b( double s ){
		
		double a =  Math.round( ( s / 60 ) * 10 )  ;
		int hu = 0;
		
		a = a / 10;
		
		//System.out.println(a);
		
		if( a >= 0.0 && a <= 0.2 ){
			hu = 0;
			str = "C";
		}else if( a >= 0.3 && a <= 1.5 )
			hu = 1;
		else if( a >= 1.6 && a <= 3.3 )
			hu = 2;
		else if( a >= 3.4 && a <= 5.4 )
			hu = 3;
		else if( a >= 5.5 && a <= 7.9 )
			hu = 4;
		else if( a >= 8.0 && a <= 10.7 )
			hu = 5;
		else if( a >= 10.8 && a <= 13.8 )
			hu = 6;
		else if( a >= 13.9 && a <= 17.1 )
			hu = 7;
		else if( a >= 17.2 && a <= 20.7 )
			hu = 8;
		else if( a >= 20.8 && a <= 24.4 )
			hu = 9;
		else if( a >= 24.5 && a <= 28.4 )
			hu = 10;
		else if( a >= 28.5 && a <= 32.6 )
			hu = 11;
		else if( a >= 32.7 )
			hu = 12;
			
		return hu;
		
	}
	
	private static void str_dir( double d ){
		
		if( d >= 112.5 && d < 337.5 )
			str = "NNE";
		else if( d >= 337.5 && d < 562.5 )
			str = "NE";
		else if( d >= 562.5 && d < 787.5 )
			str = "ENE";
		else if( d >= 787.5 && d < 1012.5 )
			str = "E";
		else if( d >= 1012.5 && d < 1237.5 )
			str = "ESE";
		else if( d >= 1237.5 && d < 1462.5 )
			str = "SE";
		else if( d >= 1462.5 && d < 1687.5 )
			str = "SSE";
		else if( d >= 1687.5 && d < 1912.5 )
			str = "S";
		else if( d >= 1912.5 && d < 2137.5 )
			str = "SSW";
		else if( d >= 2137.5 && d < 2362.5 )
			str = "SW";
		else if( d >= 2362.5 && d < 2587.5 )
			str = "WSW";
		else if( d >= 2587.5 && d < 2812.5 )
			str = "W";
		else if( d >= 2812.5 && d < 3037.5 )
			str = "WNW";
		else if( d >= 3037.5 && d < 3262.5 )
			str = "NW";
		else if( d >= 3262.5 && d < 3487.5 )
			str = "NNW";
		else
			str = "N";
	}

}
