import java.util.Scanner;

public class Main {
	public static void main(String ar[])
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), m = sc.nextInt();

		String[] ga = new String[n];
		String[] gb = new String[m];

		sc.nextLine();

		for (int i = 0; i < n; ++i)
		{
			ga[i] = sc.nextLine();
		}

		for (int i = 0; i < m; ++i)
		{
			gb[i] = sc.nextLine();
		}

		sc.close();

		boolean flag = true;

		// たて(始点)
		for (int i = 0; i <= n - m; ++i)
		{
			// よこ
			for (int j = 0; j <= n - m; ++ j)
			{
				// mのループ
				// 盾
				for (int k = 0; k < m; ++k)
				{
					if (! ga[i + k].substring(j, j + m).equals(gb[k]))
					{
						flag = false;

						break;
					}
				}

				if (flag)
				{
					System.out.println("Yes");
					return;
				}

				flag = true;
			}
		}

		System.out.println("No");
	}
}
