import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int N = s.length();
		int[] ii = new int[26];  
		
		for(int i=0; i < N; i++){
			ii[s.charAt(i) - 'a'] += 1;
		}

		for(int i: ii) {
			if(i>1) { System.out.println("no"); return; }
		}
		
		
		System.out.println("yes");
		return;
	}


}
