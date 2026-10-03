import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Solver extends Main{
	Solver(){
	}
}//Solver_end

class Main{
	static int imax=Integer.MAX_VALUE;
	static long lmax=Long.MAX_VALUE;
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner sc=new Scanner(System.in);
		int n=readI(sc);
		int[] scr=new int[n];
		for(int i=0; i<n; i++){
			scr[i]=readI(sc);
		}
		
		int[][] dpt=new int[n+1][10001];
		dpt[0][0]=1;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<10000; j++){
				if(dpt[i][j]>0 && j+scr[i]<=10000){
					dpt[i+1][j+scr[i]]=1;
					dpt[i+1][j]=1;
				}
			}
		}
		
		int ans=0;
		
		for(int i=0; i<dpt[0].length; i++){
			if(dpt[n][i]>0 && i%10!=0 && ans<i){
				ans=i;
			}
		}
		
		puts(ans);
		
		new Solver();		
	}//main_end
	
	//utility
	static int readI(Scanner sc){
		return Integer.parseInt(sc.nextLine().trim());
	}
	static long readL(Scanner sc){
		return Long.parseLong(sc.nextLine().trim());
	}
	static String readS(Scanner sc){
		return sc.nextLine().trim();
	}
	static int[] readlnI(Scanner sc, String dl){
		return Arrays.stream(sc.nextLine().trim().split(dl)).mapToInt(Integer::parseInt).toArray();
	}
	static long[] readlnL(Scanner sc, String dl){
		return Arrays.stream(sc.nextLine().trim().split(dl)).mapToLong(Long::parseLong).toArray();
	}
	static String[] readlnS(Scanner sc, String dl){
		return sc.nextLine().trim().split(dl);
	}
	@SuppressWarnings("unchecked")
	static <T> void puts(T... args){
		for(int i=0; i<args.length-1; i++){
			System.out.printf("%s ",args[i]);
		}
		System.out.println(args[args.length-1]);
	}
	static void puts(int[] ary){
		for(int i=0; i<ary.length-1; i++){
			System.out.printf("%d ",ary[i]);
		}
		System.out.println(ary[ary.length-1]);
	}
	static void puts(long[] ary){
		for(int i=0; i<ary.length-1; i++){
			System.out.printf("%d ",ary[i]);
		}
		System.out.println(ary[ary.length-1]);
	}
	static void bs(){
		System.out.println("");
	}
	static void tblSort(int[][] tbl){
		Arrays.sort(tbl, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[0]==b[0]){
					return b[1]-a[1];
				}else{
					return b[0]-a[0];
				}
			}
		});
	}
}