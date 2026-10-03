import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line[] = br.readLine().split(" ");
			System.out.println(ans(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}
	}

	private static String ans(int deg, int dis) {
		int power = getWindPower(dis);
		if (power == 0)
			return "C 0";
		return String.format("%s %d", getWindDir(deg), power);
	}

	private static int getWindPower(int dis) {
		int ms = (int) Math.round(dis / 6.0);
		if (ms <= 2)
			return 0;
		if (ms <= 15)
			return 1;
		if (ms <= 33)
			return 2;
		if (ms <= 54)
			return 3;
		if (ms <= 79)
			return 4;
		if (ms <= 107)
			return 5;
		if (ms <= 138)
			return 6;
		if (ms <= 171)
			return 7;
		if (ms <= 207)
			return 8;
		if (ms <= 244)
			return 9;
		if (ms <= 284)
			return 10;
		if (ms <= 326)
			return 11;
		return 12;
	}

	private static String getWindDir(int deg) {
		if (deg < 113)
			return "N";
		if (deg < 338)
			return "NNE";
		if (deg < 563)
			return "NE";
		if (deg < 788)
			return "ENE";
		if (deg < 1013)
			return "E";
		if (deg < 1238)
			return "ESE";
		if (deg < 1463)
			return "SE";
		if (deg < 1688)
			return "SSE";
		if (deg < 1913)
			return "S";
		if (deg < 2138)
			return "SSW";
		if (deg < 2363)
			return "SW";
		if (deg < 2588)
			return "WSW";
		if (deg < 2813)
			return "W";
		if (deg < 3038)
			return "WNW";
		if (deg < 3263)
			return "NW";
		if (deg < 3488)
			return "NNW";

		return "N";
	}

}
