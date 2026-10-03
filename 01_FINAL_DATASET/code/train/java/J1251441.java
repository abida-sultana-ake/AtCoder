import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.function.LongSupplier;
import java.util.stream.IntStream;

public class Main{
	static final Scanner s=new Scanner(System.in);
	static final long[] fal_rnd(long[] ar,LongSupplier sp){
		int l=-1,r=ar.length;
		while(l+1!=r)
			ar[Math.random()<0.5?++l:--r]=sp.getAsLong();
		return ar;
	}
	static final void REP(int t,IntConsumer i){
		for(int v=0;v<t;v++)
			i.accept(v);
	}
	static final void REPR(int t,IntConsumer i){
		for(int v=t-1;v>=0;v--)
			i.accept(v);
	}
	static final IntStream REPS(int v){
		return IntStream.range(0,v);
	};
	public static void main(String[] __){
		int n=s.nextInt(),W=s.nextInt();
		HashMap<Integer,Integer> dp=new HashMap<>(65535);
		dp.put(0,0);
		for(int i=0;i<n;i++) {
			HashMap<Integer,Integer> ndp=new HashMap<>(dp);
			int w=s.nextInt(),v=s.nextInt();
			for(Entry<Integer,Integer> e:dp.entrySet()) {
				if(e.getKey()+w<=W)
					ndp.merge(e.getKey()+w,e.getValue()+v,Math::max);
			}
			dp=ndp;
		}
		System.out.println(dp.values().parallelStream().max(Comparator.naturalOrder()).orElse(0));
	}
}
