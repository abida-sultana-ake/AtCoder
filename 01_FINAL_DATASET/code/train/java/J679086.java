import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
 
public class Main {
	public static void main(String[] args) throws NumberFormatException,
	IOException {Solve solve = new Solve();solve.solve();}
}
class Solve{
	void dump(int[]a){for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");System.out.println();};
	void dump(int[]a,int n){for(int i=0;i<a.length;i++)
		System.out.printf("%"+n+"d",a[i]);System.out.println();};
	void solve() throws NumberFormatException, IOException{
		ContestScanner in = new ContestScanner();
		Writer out = new Writer();
		int w = in.nextInt();
		int h = in.nextInt();
		if(w%16==0 && h%9==0){
			System.out.println("16:9");
		}else{
			System.out.println("4:3");
		}
	}
}

class MultiSet<T> extends HashMap<T, Integer>{
	@Override
	public Integer get(Object key){return containsKey(key)?super.get(key):0;}
	public void add(T key,int v){put(key,get(key)+v);}
	public void add(T key){put(key,get(key)+1);}
	public void sub(T key){
		final int num = get(key);
		if(num==1) remove(key);
		else put(key, num-1);
	}
}
class Writer extends PrintWriter{
	public Writer(String filename) throws IOException
	{super(new BufferedWriter(new FileWriter(filename)));}
	public Writer() throws IOException{super(System.out);}
}
class ContestScanner {
	private InputStreamReader reader;int c=-2;
	public ContestScanner() throws IOException 
	{reader = new InputStreamReader(System.in);}
	public ContestScanner(String filename) throws IOException
	{reader = new InputStreamReader(new FileInputStream(filename));}
	public String nextToken() throws IOException {
		StringBuilder sb = new StringBuilder();if(c==-2) c=reader.read();
		while(c!=-1&&(c==' '||c=='\t'||c=='\n'||c=='\r'))c=reader.read();
		while(c!=-1&&c!=' '&&c!='\t'&&c!='\n'&&c!='\r'){sb.appendCodePoint(c);c=reader.read();}
		return sb.toString();
	}
	public String readLine() throws IOException{
		StringBuilder sb = new StringBuilder();if(c==-2)c=reader.read();
		while(c!=-1&&c!='\n'&&c!='\r'){sb.appendCodePoint(c);c=reader.read();}
		return sb.toString();
	}
	public long nextLong() throws IOException, NumberFormatException
	{return Long.parseLong(nextToken());}
	public int nextInt() throws NumberFormatException, IOException
	{return (int) nextLong();}
	public double nextDouble() throws NumberFormatException, IOException 
	{return Double.parseDouble(nextToken());}
}