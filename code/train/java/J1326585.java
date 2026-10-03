import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
	public void solve(FastScanner sc, PrintWriter out) throws IOException
	{
		boolean result = true;
		String input = "";
		input = sc.nextLine();

		for(int i = 0; i < input.length(); ++i)
		{
			for(int j = 0; j < input.length(); ++j)
			{
				if ((i != j) && (input.charAt(i) == input.charAt(j)))
				{
					result = !result;
					break;
				}
			}

			if(!result) break;
		}

		if(result)
		{
			out.println("yes");
		}
		else
		{
			out.println("no");
		}
	}

	public void run()
	{
		try
		{
			FastScanner sc = new FastScanner();
			PrintWriter out = new PrintWriter(System.out);

			this.solve(sc, out);
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new Main().run();
	}

	class FastScanner
	{

		private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 2048);
		private StringTokenizer st;

		public String next()
		{
			while (this.st == null || !st.hasMoreTokens())
			{
				try
				{
					this.st = new StringTokenizer(this.br.readLine());
					System.out.println("");
				}
				catch (IOException e)
				{
					e.printStackTrace();

				}
			}
			return this.st.nextToken();
		}

		public String nextLine() throws IOException
		{
			return this.br.readLine();
		}

	}

}
