
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int N;
    private final int T;
    private final int[] end;
    private final int[] start;

    public Main() {
	N = Integer.parseInt(scan.next());
	T = Integer.parseInt(scan.next());
	end = new int[N];
	start = new int[N];
	
	for (int i = 0; i < N; i++) {
	    int t = Integer.parseInt(scan.next());
	    start[i] = t;
	    end[i] = start[i] + T;
	}

	scan.close();
    }

    public final void answer() {
	int ans = end[N-1];
	int blank = 0;
	for (int i = 1; i < N; i++) {
	    int tmp = start[i] - end[i-1];
	    if(tmp > 0) blank += tmp;
	}
	ans -= blank;
	System.out.println(ans);
    }
}
