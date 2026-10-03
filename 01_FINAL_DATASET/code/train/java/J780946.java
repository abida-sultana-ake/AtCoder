import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;
    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }
    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    private void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
    public boolean hasNext() { skipUnprintable(); return hasNextByte();}
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public int nextInt(){
    	return (int)nextLong();
    }
    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return minus ? -n : n;
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
}
public class Main{
	static int inf=Integer.MAX_VALUE/2;
	static class ver implements Comparable<ver>{
		public int num,cost;
		public ver(int x,int y){
			this.num=x; this.cost=y;
		}
		public int compareTo(ver o){
			return o.cost-this.cost;
		}
	}
	static int v,e;
	static LinkedList<Integer>[] g;
	static int[] dijkstra(int s){
		int[] d=new int[v];
		boolean[] used=new boolean[v];
		Arrays.fill(used,false);
		Arrays.fill(d,-1);
		d[s]=s;
		Queue<ver> que=new PriorityQueue<ver>();
		que.add(new ver(s,s));
		while(!que.isEmpty()){
			ver now=que.poll();
			int point=now.num;
			if(used[point]) continue;
			used[point]=true;
			for(Iterator<Integer> it=g[point].iterator();it.hasNext();){
				int next=it.next();
				if(d[next]!=next){
					d[next]=Math.min(d[point],next);
					que.add(new ver(next,d[next]));
				}
			}
		}
		return d;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
        FastScanner sc=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        while(sc.hasNext()){
        	v=sc.nextInt();
        	e=sc.nextInt();
        	int s=sc.nextInt(); --s;
        	g=new LinkedList[v];
        	for(int i=0;i<v;i++) g[i]=new LinkedList<Integer>();
        	for(int i=0;i<e;i++){
        		int u=sc.nextInt();
        		int v=sc.nextInt();
        		--u; --v;
        		g[u].add(v);
        		g[v].add(u);
        	}
        	int[] res=dijkstra(s);
        	for(int i=0;i<v;i++) if(res[i]==i) out.println(i+1);
        	out.flush();
        }
    }
}