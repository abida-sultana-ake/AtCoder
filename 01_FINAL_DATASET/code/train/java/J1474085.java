
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Main m = new Main();
	m.answer();
    }

    private Scanner scan = new Scanner(System.in);
    private final int N;
    private final int K;
    private final long[] w;
    private final int[] p;

    public Main() {
	N = Integer.parseInt(scan.next());
	K = Integer.parseInt(scan.next());
	w = new long[N];
	p = new int[N];
	for (int i = 0; i < N; i++) {
	    w[i] = Long.parseLong(scan.next()) * 100;
	    p[i] = Integer.parseInt(scan.next());
	}

	scan.close();
    }

    public final void answer() {
	boolean[] checked = new boolean[N];
	long salt = 0;
	long total = 0;
	for (int step = 0; step < K; step++) {
	    double max = 0;
	    int index = 0;
	    for (int i = 0; i < N; i++) {
		if(!checked[i]) {
		    double tmp = (double)(w[i]*p[i]+salt) / (total+w[i]);
		    if(tmp > max) {
			max = tmp;
			index = i;
		    }
		}
	    }
	    checked[index] = true;
	    salt = salt + w[index]*p[index];
	    total = total + w[index];
	}
	
	System.out.println((double)salt/total);
    }
}
