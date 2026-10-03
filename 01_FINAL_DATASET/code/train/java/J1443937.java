import java.util.Scanner;
import java.util.function.IntBinaryOperator;

// Java8
public class Main
{
	Scanner sc = new Scanner(System.in);

	int[][] b = new int[2][3], c = new int[3][2];
	Char[][] field = new Char[3][3];

	public static void main(String[] args) throws Exception
	{
		new Main().run();
	}

	int calc()
	{
		int res = 0;
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(field[i][j] == field[i+1][j]) res += b[i][j];
				if(field[j][i] == field[j][i+1]) res += c[j][i];
			}
		}
		return res;
	}
	
	int search(int rest, boolean turn)
	{
		if(rest==0) return calc();
		Selector sel = turn ? new MaxSelector() : new MinSelector();
		Char putChar = turn ? Char.O : Char.X;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(field[i][j]==null)
				{
					field[i][j] = putChar;
					sel.put(search(rest-1, !turn));
					field[i][j] = null;
				}
			}
		}
		return sel.get();
	}

	void run()
	{
		final IntBinaryOperator adder = (a, b) -> a + b;
		int sum = 0;
		for(int i=0; i<2; i++) for(int j=0; j<3; j++) sum += b[i][j] = sc.nextInt();
		for(int i=0; i<3; i++) for(int j=0; j<2; j++) sum += c[i][j] = sc.nextInt();
		int r = search(9, true);
		System.out.println(r);
		System.out.println(sum - r);
	}
}
abstract class Selector
{
	int value;
	boolean valid;
	
	protected Selector()
	{
		valid = false;
	}
	
	public int get()
	{
		if(valid) return value;
		else throw new IllegalStateException();
	}
	
	public void put(int x)
	{
		if(valid)
		{
			if(select(x, value))
			{
				value = x;
			}
		}
		else
		{
			value = x;
			valid = true;
		}
	}
	
	public abstract boolean select(int target, int current);
}
class MaxSelector extends Selector
{
	@Override
	public boolean select(int target, int current)
	{
		return target > current;
	}
}
class MinSelector extends Selector
{
	@Override
	public boolean select(int target, int current)
	{
		return target < current;
	}
}
enum Char
{
	O, X;
}