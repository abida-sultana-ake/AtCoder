import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
 
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
 
		int cost = n>k ? k*x + (n-k)*y : n*x;
		System.out.println(cost);
	}
}