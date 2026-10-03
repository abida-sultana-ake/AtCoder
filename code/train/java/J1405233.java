import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ある時刻の積雪深 H1 と その 1 時間前の積雪深 H2 が与えられます。この時、この 1 時間の積雪深差 H1 − H2 の値を計算して出力してください。
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String h1 = br.readLine();
		String h2 = br.readLine();
		System.out.println(Integer.parseInt(h1) - Integer.parseInt(h2));
	}

}