import java.util.*;
import java.io.*;
public class Main {
	public static boolean[] b;
	static int[] FF;
	static int[] A;
	public static void main(String[] ard)  throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		String[] s=br.readLine().trim().split("\\s++");
		int a=Integer.valueOf(s[0]);
		int b=Integer.valueOf(s[1]);
		int c=Integer.valueOf(s[2]);
		int d=Integer.valueOf(s[3]);
		int upper=Math.min(b,d);
                int lower=Math.max(a,c);
                 pw.println(Math.max(0,upper-lower));
		
	pw.close();
		
	}
	 static long solve(int[] A, int k){
	       //int[] sum=new int[A.length+k+1];
	     ///  for(int i=1;i<=A.length;i++)
		 int n=A.length-1;
	       long ans=0;
	      /// Arrays.sort(A);
	       for(int i=1;i<=n-k+1;i++)
	       {
	           ans=Math.max(ans,Math.abs(A[i]-A[i+k-1]));
	       }
	       
	       return ans;
	    }
	public static boolean palin(String s)
	{
	   int i=0;
	   int j=s.length()-1;
	   while(i<j)
	   {
		   if(s.charAt(i)==s.charAt(j))
		   {
			   i++;
			   j--;
		   }
		   else return false;     
	   }
	   return true;
	}
	
}