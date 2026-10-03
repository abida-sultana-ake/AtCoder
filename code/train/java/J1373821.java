import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 許容日
        int a = sc.nextInt(); // 購入日
        int b = sc.nextInt(); // 食べた日

        int afterOpenDate = b - a;        // 食べた日が賞味期限の何日後か
        String result;

        if (afterOpenDate <= 0) {
            result = "delicious";
        } else if (afterOpenDate <= x) {
            result = "safe";
        } else {
            result = "dangerous";
        }

        System.out.println(result);
	}

}