import java.util.*;

// ABC 12-C
// https://abc012.contest.atcoder.jp/submissions/me#

public class Main {

	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
	    
	    String s = in.next();
	    s = s.toLowerCase();
	    s = s.substring(0, 1).toUpperCase() + s.substring(1);
	    System.out.println(s);
	}
}
