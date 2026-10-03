///package CodeChef;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static int mod=1000000007;
   public static int minPlus=mod;
	public static void main(String[] ard)  throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		String[] s=br.readLine().trim().split("\\s++");
		int S=Integer.valueOf(s[0]);
		int A=Integer.valueOf(s[1]);
		int B=Integer.valueOf(s[2]);
		if(Math.abs(A-S)<Math.abs(S-B))pw.println("A");
		else pw.println("B");
		pw.close();
	}
	public  static void go (String num, String s, int sum, int i) {
	    if (i>=num.length()) {
	      int t = 0;
	      long rs = 0;
	      StringTokenizer st = new StringTokenizer(s,"+");
	      t = st.countTokens();
	      while (st.hasMoreTokens()) {
	        rs+=Long.parseLong((String)st.nextToken());
	      }
	      if (rs == sum) minPlus = Math.min(minPlus,t);
	    } else {
	      if (i == 0) go (num,""+num.charAt(i), sum, i+1);
	      else {
	        go (num,s+"+"+num.charAt(i),sum,i+1);
	        go (num,s+num.charAt(i),sum,i+1);
	      }
	 
	    }
	        
	 
	  }
	public static int pa(int n)
	{     int a=0;
	      int b=0;
		
		if(n<=0)return 1;
		System.out.println("kumar");
		 a+=pa(n-1);
		 System.out.println("prabhat");  
		 b+=pa(n-1);
		//System.out.println( callme("vikrant"));
	   
		return a+b;
	}
	public static  String callme(String s)
	{
		return s;
	}
	public static boolean palin(String s)
	{
		int i=0;
		int j=s.length()-1;
		while(i!=j)
		{
			if(s.charAt(i)!=s.charAt(j))return false;
			i++;
			j--;
		}
	   return true;	
	}
	

}
