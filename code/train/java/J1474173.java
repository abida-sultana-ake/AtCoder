
import java.util.Arrays;
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
    private Merit[] merits;
    private double OK = 0;
    private double NG = 100;

    public Main() {
	N = Integer.parseInt(scan.next());
	K = Integer.parseInt(scan.next());
	w = new long[N];
	p = new int[N];
	for (int i = 0; i < N; i++) {
	    w[i] = Long.parseLong(scan.next());
	    p[i] = Integer.parseInt(scan.next());
	}
	
	merits = new Merit[N];
	for (int i = 0; i < N; i++) {
	    merits[i] = new Merit();
	}

	scan.close();
    }

    public final void answer() {
	for (int i = 0; i < 10000; i++) {
	    func();
	}
	System.out.println(OK);
    }

    private final boolean checked(double rate) {
	for (int i = 0; i < N; i++) {
	    merits[i].merit = w[i] * (p[i] - rate);
	}
	Arrays.sort(merits);

	double tmp = 0;
	for (int i = 0; i < K; i++) {
	    tmp += merits[i].merit;
	}

	return tmp >= 0;
    }

    private final void func() {
	double rate = (OK+NG)/2;
	if(checked(rate)) OK = rate;
	else NG = rate;
    }

    private static class Merit implements Comparable<Merit> {
	double merit;

	@Override
	public int compareTo(Merit m) {
	    return this.merit > m.merit ? -1 : 1;
	}
    }
}
