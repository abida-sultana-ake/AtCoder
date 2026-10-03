import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt(), H = sc.nextInt(), N = sc.nextInt();

		int xmax = W, ymax = H; //xy平面最大の座標
		int xmin = 0, ymin = 0; //xy平面最小の座標
		
		for(int i=0; i<N; i++){
			int x = sc.nextInt(), y = sc.nextInt(), a = sc.nextInt();
			
			if(a==1){//xminが変わる可能性
				xmin = Math.max(xmin, x);
			}
			else if(a==2){//xmaxが変わる可能性
				xmax = Math.min(x, xmax);
			}
			else if(a==3){//yminが変わる可能性
				ymin = Math.max(ymin, y);
			}
			else if(a==4){//ymaxが変わる可能性
				ymax = Math.min(y, ymax);
			}
		}
		System.out.println(Math.max(0,xmax-xmin) * Math.max(0,ymax-ymin));//0になることも考慮
	}
}