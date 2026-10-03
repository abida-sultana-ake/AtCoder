import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int n=s.nextInt()+1, d[][]=new int[n][n];
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				d[i][j]=s.nextInt();
			}
		}
		for(int i=1;i<n;i++) Arrays.parallelPrefix(d[i], (o1,o2)->o1+o2);
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				d[i][j]+=d[i-1][j];
			}
			//System.out.println(Arrays.toString(d[i]));
		}

		for(int q=s.nextInt();q>0;q--) {
			int p=s.nextInt(),max=-114514;
			for(int x=1,y;x<=p;x++) {
				y=p/x;
				//System.out.printf("%d,%d\n",x,y);
				for(int i=y;i<n;i++) {
					for(int j=x;j<n;j++) {
						max=Math.max(
								max,
								 d[i  ][j  ]
								-d[i-y][j  ]
								-d[i  ][j-x]
								+d[i-y][j-x]);
					}
				}
				//System.out.println(max);

				final int yy=x,xx=y;
				//System.out.printf("%d,%d\n",xx,yy);
				for(int i=yy;i<n;i++) {
					for(int j=xx;j<n;j++) {
						max=Math.max(
								max,
								 d[i   ][j   ]
								-d[i-yy][j   ]
								-d[i   ][j-xx]
								+d[i-yy][j-xx]);
					}
				}
				//System.out.println(max);
			}
			System.out.println(max);
		}
	}
}
