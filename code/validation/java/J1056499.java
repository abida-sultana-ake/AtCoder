import java.util.*;
public class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int sx=s.nextInt(),sy=s.nextInt(),tx=s.nextInt(),ty=s.nextInt(),
		x=sx,y=sy;
		ArrayDeque<Character> deque = new ArrayDeque<>(5000);
		//start
		for(;y<ty  ;y++) deque.add('U');
		for(;x<tx  ;x++) deque.add('R');
		//t1
		for(;y>sy  ;y--) deque.add('D');
		for(;x>sx  ;x--) deque.add('L');
		//s1
		x--;deque.add('L');
		for(;y<ty  ;y++) deque.add('U');
		y++;deque.add('U');
		for(;x<tx  ;x++) deque.add('R');
		y--;deque.add('D');
		//t2
		x++;deque.add('R');
		for(;y>sy  ;y--) deque.add('D');
		y--;deque.add('D');
		for(;x>sx  ;x--) deque.add('L');
		y++;deque.add('U');
		//s2
		System.out.println(deque.toString().replaceAll("[^DLRU]", ""));
	}
}