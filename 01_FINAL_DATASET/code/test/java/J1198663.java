import java.util.*;
 
// ABC 6-C
// http://abc006.contest.atcoder.jp/tasks/abc006_3
 
public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);

	    String s = in.next();
	    s = s.replace("a", "");
	    s = s.replace("i", "");
	    s = s.replace("u", "");
	    s = s.replace("e", "");
	    s = s.replace("o", "");
	    
	    System.out.println(s);
	}
}
