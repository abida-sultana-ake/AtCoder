import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			long price = sc.nextLong();
			long setPrice = sc.nextLong();
			long totalQty = sc.nextLong();
			long setQty = sc.nextLong();

			
			long tmpTotalPrice = 0;
			long currentQty = 0;
			// 1. まずはセット商品を買えるだけ購入
			for (long i = currentQty; i + setQty < totalQty; i = i + setQty) {
				tmpTotalPrice += setPrice;
				currentQty = i + setQty;
			}
			
			long setTotalPrice = tmpTotalPrice;
			
			// 2. 単品で買えるだけ購入
			for (long i = currentQty; i < totalQty; i = i + 1) {
				tmpTotalPrice += price;
				currentQty = i;
			}
			
			// 1と2で求めた値段よりセットだけ買った方が安い場合もあるので比較
			long totalPrice = Math.min(setTotalPrice + setPrice, tmpTotalPrice);
			
			System.out.println(totalPrice);
		}
	}
}
