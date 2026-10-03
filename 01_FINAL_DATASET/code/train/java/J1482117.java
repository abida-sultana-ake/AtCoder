import java.util.Scanner;

/**
 * http://abc020.contest.atcoder.jp/tasks/abc020_c
 */
public class Main {

	static int H,W,T;
	static Cell[][] f;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		T = sc.nextInt();
		f = new Cell[H][W];
		Cell start = null;
		Cell goal = null;
		for(int y=0; y<H; y++){
			String h = sc.next();
			for(int x=0; x<W; x++){
				char c = h.charAt(x);
				f[y][x] = new Cell(x,y,c=='#');
				if(c=='S') start = f[y][x];
				if(c=='G') goal = f[y][x];
			}
		}
		sc.close();
		
		Cell c = start;
		c.maxBlackTime = T+H*W;
		while(c!=goal){
			
			c.fix = true;
			
			updateCell(c, c.y-1, c.x);
			updateCell(c, c.y+1, c.x);
			updateCell(c, c.y, c.x-1);
			updateCell(c, c.y, c.x+1);

			double maxTime = 0;
			c = null;
			for(int y=0; y<H; y++){
				for(int x=0; x<W; x++){
					if(!f[y][x].fix  && maxTime < f[y][x].maxBlackTime){
						maxTime = f[y][x].maxBlackTime;
						c = f[y][x];
					}
				}
			}
			
		}
	
		System.out.println((long)goal.maxBlackTime);
		
	}
	
	static void updateCell(Cell c, int y, int x){
		if(x<0 || x>=W || y<0 || y>=H) return;
		Cell target = f[y][x];
		if(target.fix) return;
		int tmpB = target.black ? c.b+1 : c.b;
		int tmpW = target.black ? c.w : c.w+1;
		if(tmpB+tmpW>T) return;
		double tmpTime = tmpB==0 ? T+H*W-tmpW : (double)(T-tmpW)/(double)tmpB;
		if(target.maxBlackTime<tmpTime){
			target.b = tmpB;
			target.w = tmpW;
			target.maxBlackTime = tmpTime;
		}

	}
	
	static class Cell{
		int x,y;
		int b = 0;
		int w = 0;
		boolean fix = false;
		double maxBlackTime = 0;
		boolean black;
		Cell(int x, int y, boolean black){
			this.x = x;
			this.y = y;
			this.black = black;
		}
	}

}