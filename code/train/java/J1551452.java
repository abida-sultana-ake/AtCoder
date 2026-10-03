import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main{
	static IntStream REPS(int v){return IntStream.range(0,v);}
	static IntStream REPS(int l,int r){return IntStream.rangeClosed(l,r);}
	static IntStream INS(int n) {return REPS(n).map(i->getInt());}
	static Scanner s=new Scanner(System.in);
	static int getInt(){return Integer.parseInt(s.next());}

	static int[][]f;
	static final int[]dx={-1,0,1,0},dy={0,-1,0,1};
	public static void main(String[]$){
		int h=getInt(),w=getInt();
		f=new int[h][w];
		int i=h*w-1,n=getInt();
		for(int k=1;k<=n;++k) {
			for(int c=getInt();c>0;--c,--i) {
				f[i/w][i/w%2==0?i%w:w-1-i%w]=k;
			}
		}
		Arrays.stream(f).map(o->Arrays.stream(o).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
				.forEach(System.out::println);
	}
}