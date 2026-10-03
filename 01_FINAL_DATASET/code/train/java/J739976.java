import java.util.Scanner;
import java.math.*;
public class Main {
	static final int div=1000000007;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc=new Scanner(System.in);
		int h=Integer.parseInt(sc.next());
		int w=Integer.parseInt(sc.next());
		int[][] map=new int[h][w];

		int[][] num=new int[h][w];
		for (int i=0;i<h;i++) {
			for (int j=0;j<w;j++) {
				map[i][j]=0;
				num[i][j]=-1;
			}
		}

		for (int i=0;i<h;i++) {
			for (int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(sc.next());
			}
		}
		for (int i=0;i<h;i++) {
			for (int j=0;j<w;j++) {
				search(h,w,i,j,map,num);
			}
		}

		int sum=0;
		for (int i=0;i<h;i++) {
			for (int j=0;j<w;j++) {
//				System.out.println(num[i][j]);
				sum=(sum+num[i][j])%div;
			}
		}
		System.out.println(sum);
	}

	public static int search(int h, int w, int x,int y, int[][]map, int[][]num) {

		if (num[x][y]==-1) {

		int up=shift(h,w,x,y,-1,0,map,num);
		int down=shift(h,w,x,y,1,0,map,num);
		int left=shift(h,w,x,y,0,-1,map,num);
		int right=shift(h,w,x,y,0,1,map,num);

		int tmp=((((1+up)%div+down)%div+left)%div+right)%div;
		num[x][y]=tmp;
		return tmp;
		}

		else return num[x][y];
	}

	public static int shift(int h, int w, int x, int y, int xshift, int yshift, int[][]map, int[][]num) {
		if(x+xshift>=0 && x+xshift<h && y+yshift>=0 && y+yshift<w && map[x+xshift][y+yshift]>map[x][y]) {
			return search(h,w,x+xshift,y+yshift,map,num);
		}
		else return 0;
	}

}
