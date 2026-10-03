import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static String s, ans = "Yes";
	public static HashMap<Character, Integer> h = new HashMap<Character, Integer>();
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(new File("input.txt"));
		Scanner in = new Scanner(System.in);
		s = in.next();
		char[] sa = s.toCharArray();
		for(char c : sa){
			if(!h.containsKey(c)) h.put(c,  1);
			else h.put(c,  h.get(c) + 1);
		}
		for(char c : h.keySet()){
			if(h.get(c) % 2 == 1){
				ans = "No";
				break;
			}
		}
		System.out.println(ans);
	}
}