import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String s = sc.next();
		LinkedList<Pair> list = new LinkedList<>();
		list.addLast(new Pair(s.charAt(0),1));
		for (int i = 1;i < s.length();i++) {
			char c = s.charAt(i);
			Pair p = list.getLast();
			if (p.c==c) {
				p.l++;
			} else {
				list.addLast(new Pair(c,1));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			if (list.size()==0) break;
			Pair p = list.removeFirst();
			sb.append(p.c).append(p.l);
		}

		System.out.println(sb.toString());
	}
}

class Pair {
	public char c;
	public int l;
	public Pair(char c, int l) {
		this.c = c;
		this.l = l;
	}
}
