import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

import java.util.ArrayList;

class Main{
	
	public Main(){}
	
	public void run(){
		try{
			Scanner s = new Scanner();
			long x = s.nextLong();
			System.out.println((int)Math.sqrt(Math.sqrt(x)));
			
		}catch(Exception e){
			e.printStackTrace();
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