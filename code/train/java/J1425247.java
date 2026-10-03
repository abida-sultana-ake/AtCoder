import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.NoSuchElementException;
 
public class Main {
	private static FastScanner sc = new FastScanner();
	static Node[] V;
	static int treed;
	static int N;
	static int black = 0;
	static int white = 0;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		
		V = new Node[N];
		for(int i=0; i<N; i++) {
			V[i] = new Node();
			V[i].id = i;
		}
		
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			V[a].nbr.add(b);
			V[b].nbr.add(a);
		}
		
		V[0].dfs1(0, -1);
		
		for(int i=0; i<N; i++) {
			V[i].visited = false;
		}
		V[0].dfs2(true);
		V[N-1].dfs2(false);
		
		if(black > white) {
			System.out.println("Fennec");
		} else {
			System.out.println("Snuke");
		}
	}
	
	static class Node {
		int id;
		boolean visited = false;
		HashSet<Integer> nbr = new HashSet<>();
		
		boolean dfs1(int d, int prev) {
			visited = true;
			if(id == N-1) {
				treed = d;
				if((treed / 2) + 1 == d) {
					nbr.remove(prev);
					V[prev].nbr.remove(id);
				}
				return true;
			}
			
			for(int x : nbr) {
				if(!V[x].visited && V[x].dfs1(d+1, id)) {
					if((treed / 2) + 1 == d) {
						nbr.remove(prev);
						V[prev].nbr.remove(id);
					}
					return true;
				}
			}
			
			return false;
		}
		
		void dfs2(boolean mode) {
			visited = true;
			if(mode) {
				black++;
			} else {
				white++;
			}
			
			for(int x : nbr) {
				if(!V[x].visited) {
					V[x].dfs2(mode);
				}
			}
		}
	}
	
	static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if(ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                if(buflen <= 0) {
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
        public long nextLong() {
            return Long.parseLong(next());
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}