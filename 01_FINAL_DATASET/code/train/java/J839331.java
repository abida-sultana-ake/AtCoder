
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	// 連続した部分文字列がkの長さをもつとすると
	// aa
	// a*a
	// のどちらかしか存在しない。このパターンを使わないということはa**a**q...と繰り返すことになるがこの方法では条件をみたすことはないからである
	// テスト
	// asdfghjklaa : 最後だけ
	// faewasdfala
	// qwertyuioaa
	// aaqwertyuiop:最初
	static String line;

	static int N;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		String text[] = line.split("");
		N = text.length;
		method(text);
	}

	static void method(String text[]) {

		for (int i = 0; i < text.length - 2; i++) {
			if (text[i].equals(text[i + 2])) {
//				i++;
				System.out.println(i + " " + (i + 2));
				return;
			}
		}

		for (int i = 0; i < text.length - 1; i++) {
			if (text[i].equals(text[i + 1])) {
//				i++;
				System.out.println(i + " " + (i + 1));
				return;
			}
		}

		System.out.println("-1 -1");
	}
}
