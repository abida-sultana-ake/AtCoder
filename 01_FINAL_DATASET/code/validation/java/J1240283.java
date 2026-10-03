import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Scanner;
 
public class Main{
	
	static final Scanner s=new Scanner(System.in);
	
	
	static final int[]
			dx={0,1,0,-1},
			dy={-1,0,1,0};
	
	public static void main(String[] __){
		int r=s.nextInt(),c=s.nextInt();
		Point start=new Point(s.nextInt()-1,s.nextInt()-1);
		Point goal =new Point(s.nextInt()-1,s.nextInt()-1);
		
		char[][] f=new char[r][];
		for(int i=0;i<r;i++) f[i]=s.next().toCharArray();
		
		ArrayDeque<Point> deque=new ArrayDeque<>();
		deque.add(start);
		
		int count=0;
		outer:
		for(;true;count++){
			for(int i=deque.size();i>0;i--) {
				Point poll=deque.poll();
				if(poll.equals(goal)) {
					break outer;
				}
				for(int j=0;j<4;j++) {
					if(f[poll.x+dx[j]][poll.y+dy[j]]=='.') {
						f[poll.x+dx[j]][poll.y+dy[j]]='#';
						deque.add(new Point(poll.x+dx[j],poll.y+dy[j]));
						
						//for(char[]ch:f)System.out.println(Arrays.toString(ch));
					}
				}
			}
		}
		System.out.println(count);
	}
}