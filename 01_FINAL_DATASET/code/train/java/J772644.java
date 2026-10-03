import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
class Main{
	
	public Main(){}
	
	public void run(){
		try{
			Scanner s = new Scanner();
			int n = s.nextInt();
			s.reset();
			int[] a = new int[n];
			int[][] f = new int[n][2];
			for(int i = 0;i<n;i++){
				a[i] = s.nextInt();
			}
			int[] cost = new int[n*2];
			for(int i = 0;i<n-1;i++){
				f[i][0] = (int)Math.abs(a[i]-a[i+1]);
				if(i!=n-2){
					f[i][1] = (int)Math.abs(a[i]-a[i+2]);					
				}else{
					f[i][1] = Integer.MAX_VALUE;
				}
			}
			Queue<Node> q = new PriorityQueue<Node>();
			boolean[] flag = new boolean[n];
			q.offer(new Node(0, 0));
			int ret = 0;
			int min = Integer.MAX_VALUE;
			while(!q.isEmpty()){
				Node t = q.remove();
//				System.out.println(t.i+"/"+t.c);
				if(flag[t.i]) continue;
				flag[t.i] = true;				
				if(t.i == n-1){
					if(t.c < min){
						min = t.c;
					}
				}
				if(t.i == n){
					ret = t.c;
					break;
				}
				if(t.i+1 < n)q.offer(new Node(t.i+1,t.c+f[t.i][0]));
				if(t.i+2 < n)q.offer(new Node(t.i+2,t.c + f[t.i][1]));
			}
			System.out.println(min);
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	class Node implements Comparable<Node> {
    int i, c;
    
    Node(int i, int c){
        this.i = i;
        this.c = c;
    }
    
    public int compareTo(Node other){
        return this.c - other.c;
    }
	}
	
	public static void main(String[] argv){
		Main main = new Main();
		main.run();
	}
	
	private class Scanner{
		private int p;
		private BufferedReader br;
		String regex = " ";
		String[] token;

		public Scanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
			p = -1;
			token = new String[0];
		}
		
		void setRegex(String str){
			this.regex = str;
		}
		
		void reset(){
			p = -1;
			token = new String[0];
		}
		
		String next() throws IOException{
			if(p < 0){
				String line = br.readLine();
				while("".equals(line))line = br.readLine();
				token = line.split(regex,0);
				p = 0;
				return token[p++];
			}else{
				if(p<token.length)return token[p++];
				p = -1;
				return null;
			}
		}
	
		int nextInt() throws NumberFormatException, IOException{
			return Integer.parseInt(next());
		}
		
		long nextLong() throws NumberFormatException, IOException{
			return Long.parseLong(next());
		
		}
		
		double nextDouble() throws NumberFormatException, IOException{
			return Double.parseDouble(next());
		}
		
		String nextString() throws NumberFormatException, IOException{
			return next();	
		}		
	}
}