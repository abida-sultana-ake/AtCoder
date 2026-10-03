
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			list.add(sc.next());
		}

		Collections.sort(list);

		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
