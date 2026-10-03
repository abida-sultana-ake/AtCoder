import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Object;
 
public class Main {
    Scanner sc = new Scanner(System.in);
   
    public static void main(String[] args) {
        new Main(); 
    }
   
    public Main() {
        new C().doIt();
    }
    class C{
    	long dp_table(int num[],int max,int ans,int cnt){
    		long dp[][] = new long[51][2501];
    		long result = 0;
    		for(int i = 0;i < max;i++){
    			dp[i][num[i]]++;
    			if(num[i] == ans)result++;
    		}
    		for(int i = 0;i < max - 1;i++){
    			long dp2[][] = new long[51][2501];
    			ans = ans + cnt;
    			for(int l = i;l < max - 1;l++){
    			for(int j = 0;j < 50*(l+1) + 1;j++){
    				for(int k = l + 1;k < max;k++){
    					dp2[k][j + num[k]] = dp[l][j] + dp2[k][j + num[k]];
    				}
    			}
    			}
    			for(int j = i+1;j < max;j++){
        			for(int k = 0;k < 2501;k++){
        				dp[j][k] = dp2[j][k];
        				if(k == ans){
        					result = result + dp[j][k];
        				}
        			}
        		}
//    			for(int j = i+1;j < max;j++){
//        			for(int k = 0;k < 40;k++){
//        				System.out.print(dp[j][k]+" ");
//        			}
//        			System.out.println();
//    			}
//    			System.out.println(result+" "+ans+" "+max+" "+i);
    		}
    		return result;
    	}
    	void doIt(){
    		int n = sc.nextInt();
    		int ans = sc.nextInt();
    		int num[] = new int[n];
    		for(int i = 0;i < n;i++){
    			num[i] = sc.nextInt();
    		}
    		long sum = 0;
    		sum = dp_table(num,n,ans,ans);
    		System.out.println(sum);
    	}
    }
}