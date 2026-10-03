import java.awt.Point;
import java.util.Scanner;
public class Main {
	public static void main(String[] args)throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		Point[] point=new Point[n];
		for(int i=0;i<n;i++){
			String[] s=sc.nextLine().split(" ");
			point[i]=new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		double max=0.0;
		for(int i=0;i<point.length;i++)
			for(int j=i+1;j<point.length;j++)
				if(max<distance(point[i],point[j]))
					max=distance(point[i],point[j]);
		System.out.println(max);

	}
	public static double distance(Point p1,Point p2){
		return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
	}
}