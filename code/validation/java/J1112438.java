import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int tx = sc.nextInt();
		int ty = sc.nextInt();
		String res = UpperRight(sx, sy, tx, ty) + DownLeft(sx, sy, tx, ty) + "L" + UpperRight(sx-1, sy, tx, ty+1) + "D" + "R" + DownLeft(sx, sy-1, tx+1, ty) + "U";
		System.out.println(res);
	}

	private static String UpperRight(int sx, int sy, int tx, int ty){
		StringBuilder ret = new StringBuilder();
		int diff = Math.abs(ty - sy);
		for(int i = 0; i < diff; i++){
			ret.append("U");
		}
		diff = Math.abs(tx - sx);
		for(int i = 0; i < diff; i++){
			ret.append("R");
		}
		return ret.toString();
	}
	
	private static String DownLeft(int sx, int sy, int tx, int ty){
		StringBuilder ret = new StringBuilder();
		int diff = Math.abs(ty - sy);
		for(int i = 0; i < diff; i++){
			ret.append("D");
		}
		diff = Math.abs(tx - sx);
		for(int i = 0; i < diff; i++){
			ret.append("L");
		}
		return ret.toString();
	}
}
