import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Main{
	static int imax=Integer.MAX_VALUE;
	static long lmax=Long.MAX_VALUE;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner sc=new Scanner(System.in);
		int n=readI(sc);
		int[] num=readlnI(sc," ");
		int[] color={0,0,0,0,0,0,0,0};
		int scr=0;
		int fr=0;
		
		for(int i=0;i<n; i++){
			scr=num[i];
			
			if(1<=scr && scr<=399){
				color[0]=1;
			}else if(400<=scr && scr<=799){
				color[1]=1;
			}else if(800<=scr && scr<=1199){
				color[2]=1;
			}else if(1200<=scr && scr<=1599){
				color[3]=1;
			}else if(1600<=scr && scr<=1999){
				color[4]=1;
			}else if(2000<=scr && scr<=2399){
				color[5]=1;
			}else if(2400<=scr && scr<=2799){
				color[6]=1;
			}else if(2800<=scr && scr<=3199){
				color[7]=1;
			}else{
				fr+=1;
			}
		}
		
		int mn=0;
		int mx=0;
		
		for(int i=0;i<color.length; i++){
			if(color[i]==1){
				mn+=1;
			}
		}
		
		if(mn==0){
			System.out.printf("%d %d\n",1, mn+fr);
		}else{
			System.out.printf("%d %d\n",mn, mn+fr);
		}
		
		
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
