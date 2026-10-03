import java.util.HashMap;
import java.util.Scanner;
public class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		Counter<Character> c = new Counter<Character>(12);
		String in = s.next();

		for(char ch='A';ch<='F';ch++)
			c.add(ch, 0);

		for(int i=0;i<in.length();i++) {
			c.add(in.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		for(int v:c.map.values()) {
			sb.append(v);
			sb.append(' ');
		}
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());
	}
}
class Counter<T> {

	public HashMap<T, Integer> map;

	public Counter(int initSize) {
		map = new HashMap<>(initSize);
	}

	public Counter() {
		this(10);
	}

	public void add(T key, int v) {
		Integer i;
		if((i=map.get(key))==null) {
			map.put(key, v);
		}else {
			map.put(key, i+v);
		}
	}
	public void add(T key) {
		add(key,1);
	}
}
