
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int N;
    private final int[] p;

    public Main() {
	N = Integer.parseInt(scan.next());
	p = new int[N];
	for (int i = 0; i < N; i++) {
	    p[i] = Integer.parseInt(scan.next()) - 1;
	}

	scan.close();
    }

    public final void answer() {
	boolean continuous = false;
	List<Integer> list = new ArrayList<Integer>();
	int count = 0;
	for (int i = 0; i < N; i++) {
	    if(p[i] == i) {
		if(continuous) {
		    count++;
		} else {
		    count = 1;
		    continuous = true;
		}
	    } else {
		if(continuous) {
		    list.add(count);
		    continuous = false;
		    count = 0;
		}
	    }
	}
	if(count > 0) list.add(count);

	int ans = 0;
	for(Integer n: list) {
	    ans += n/2;
	    if(n%2 != 0) ans++;
	}

	System.out.println(ans);
    }
}
