
import java.util.Scanner;

/**
 * お遊び
 *
 * @author s-sugimoto
 */
public class Main {

	/**
	 * 隠蔽
	 */
	private Main() {
	}

	/**
	 * メイン
	 *
	 * @param args 起動引数
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 100A
		double a = scanner.nextInt();
		// 100B
		double b = scanner.nextInt();
		// C
		double c = scanner.nextInt();
		// D
		double d = scanner.nextInt();
		// 砂糖は100GあたりEとけるらしい
		double e = scanner.nextInt();
		// 砂糖と水の質量の合計がF
		double f = scanner.nextInt();

		double satoumizu = 100 * a;
		double satou = 0.0;
		double noudo = 0.0;
		for (int i = 0; i * a * 100 <= f; i++) {
			for (int j = 0; (i * a + j * b) * 100 <= f; j++) {
				// 溶かすことのできる砂糖の量
				double mizu = (i * a + j * b) * 100;
				double satouLimit = (i * a + j * b) * e < f - mizu ? (i * a + j * b) * e : f - mizu;

				for (int k = 0; k * c <= satouLimit; k++) {
					int dsSatouLimitCount = (int) ((satouLimit - k * c) / d);
					double newSatou = k * c + dsSatouLimitCount * d;
					double newSatoumizu = mizu + newSatou;

					// System.out.println(String.format("砂糖水の量:%f,cの砂糖:%f,dの砂糖%f,総砂糖:%f", (i * a + j * b) * 100 +
					// newSatou, c, d,
					// newSatou));

					if (i + j != 0 && k + dsSatouLimitCount != 0) {
						double newnoudo = newSatou * 100 / newSatoumizu;
						// System.out.println(String.format("砂糖水の量:%f,cの砂糖:%f,dの砂糖%f,総砂糖:%f,濃度:%f",
						// (i * a + j * b) * 100 + newSatou, c, d, newSatou, newnoudo));

						if (noudo < newnoudo && satoumizu <= f) {
							satou = newSatou;
							satoumizu = newSatoumizu;
							noudo = newnoudo;
						}
					}
				}
			}
		}

		System.out.println((int) satoumizu + " " + (int) satou);
	}
}
