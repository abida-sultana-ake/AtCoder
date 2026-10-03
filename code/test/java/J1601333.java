import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{ new Main(new Reader()); }
	public Main(Reader rr) throws IOException{
		int a=rr.ni()*100, b=rr.ni()*100, c=rr.ni(), d=rr.ni(), e=rr.ni(), f=rr.ni(), sugar=0, water=a;
		int[] waters1=new int[f];
		int[] waters2=new int[f];
		ArrayList<Integer> vals=new ArrayList<Integer>();
		for(int i=0; i<waters1.length; i++) waters1[i]=i*a;
		for(int i=0; i<waters2.length; i++) waters2[i]=i*b;
		for(int i=0; i<waters1.length; i++){
			for(int j=0; j<waters2.length; j++){
				if(i==0&&j==0) continue;
				if(waters1[i]+waters2[j]<=f){
					vals.add(waters1[i]+waters2[j]);
				}
			}
		}
		double best=0;
		int bestSugar=0;
		int bestWater=0;
		int[] ways1=new int[f];
		int[] ways2=new int[f];
		for(int i=0; i<ways1.length; i++) ways1[i]=i*c;
		for(int i=0; i<ways2.length; i++) ways2[i]=i*d;
		for(int i=0; i<ways1.length; i++){
			for(int j=0; j<ways2.length; j++){
				if(i==0&&j==0) continue;
				int check=ways1[i]+ways2[j];
				for(int k=0; k<vals.size(); k++){
					int check2=check;
					if(vals.get(k)+check2>f) continue;
					while((int)Math.ceil((double)check2*100/vals.get(k))<=e&&vals.get(k)+check2<=f) check2+=check;
					check2-=check;
					double check3=((double)100*check2)/((double)vals.get(k)+(check2));
					if(check3>best){
						best=check3;
						bestWater=vals.get(k);
						bestSugar=check2;
					}
				}
			}
		}
		if(bestSugar>0)
			System.out.println((bestWater+bestSugar)+" "+bestSugar);
		else
			System.out.println(a+" "+0);
	}
	static class Reader{
		private DataInputStream din;
		private byte[] buffer=new byte[1024];
		private int bufP, bytR;
		public Reader() throws IOException{
			din=new DataInputStream(System.in);
			bufP=bytR=0;
		}
		public Reader(String file) throws IOException{
			din=new DataInputStream(new FileInputStream(file));
			bufP=bytR=0;
		}
		private String rl() throws IOException{
			byte[] buf=new byte[1024];
			int cnt=0, c;
			while((c=read())!=-1){
				if(c=='\n') break;
				buf[cnt++]=(byte)c;
			}
			return new String(buf, 0, cnt);
		}
		private int ni() throws IOException{
			int num=0;
			byte c=read();
			while(c<=' ') c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do{
				num=num*10+c-'0';
			} while((c=read())>='0'&&c<='9');
			if(neg) return -num;
			return num;
		}
		private long nl() throws IOException{
			long num=0;
			byte c=read();
			while(c<=' ') c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do{
				num=num*10+c-'0';
			} while((c=read())>='0'&&c<='9');
			if(neg) return -num;
			return num;
		}
		private double nd() throws IOException{ return Double.parseDouble(ns()); }
		private char nc() throws IOException{ return (char)next(); }
		private String ns() throws IOException{
			int c=next();
			StringBuilder sb=new StringBuilder();
			while(!(isChar(c))){
				sb.appendCodePoint(c);
				c=read();
			}
			return sb.toString();
		}
		private char[] ns(int n) throws IOException{
			char[] buf=new char[n];
			int c=next(), r=0;
			while(r<n&&!(isChar(c))){
				buf[r++]=(char)c;
				c=next();
			}
			return n==r?buf:Arrays.copyOf(buf, r);
		}
		private char[][] nm(int n, int m) throws IOException{
			char[][] map=new char[n][];
			for(int i=0; i<n; i++) map[i]=ns(m);
			return map;
		}
		private int[] na(int n) throws IOException{
			int[] a=new int[n];
			for(int i=0; i<n; i++) a[i]=ni();
			return a;
		}
		private boolean isChar(int c) throws IOException{ return !(c>=33&&c<=126); }
		private int next() throws IOException{ int c; while((c=read())!=-1&&isChar(c)); return c; }
		private byte read() throws IOException{
			if(bufP==bytR){
				bytR=din.read(buffer, bufP=0, 1024);
				if(bytR==-1) buffer[0]=-1;
			}
			return buffer[bufP++];
		}
		public void close() throws IOException{
			if(din==null) return;
			din.close();
		}
	}
}
