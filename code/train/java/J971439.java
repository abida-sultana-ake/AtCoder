import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
 
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int l = s.length();
		char last = s.charAt(0);
		int cnt = 0;
		for(int i = 1; i < l; i++){
			char c = s.charAt(i);
			if(c!=last){
				cnt++;
				last = c;
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}