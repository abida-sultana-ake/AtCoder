import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;

public class Main {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static int n,m;
	static int[] v,t;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int sum = 0;
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(str[i]);
			a[i] = num;
			sum += num;
		}
		int ave = (int)Math.round(1.0*sum/n);
		int cost = 0;
		for(int i = 0; i < n; i++){
			int c = a[i]-ave;
			cost += c*c;
		}
		sb.append(cost);
		System.out.println(sb);
	}
}