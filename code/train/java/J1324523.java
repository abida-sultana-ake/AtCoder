import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] points  = new int[size];
		int sum =0;
		for (int i = 0; i < size; i++) {
			points[i] = s.nextInt();
			sum += points[i];
		}
		if (sum %10 != 0) {
			System.out.println(sum);
		}else{
			int SmallestNon10 = findSmallestNon10(points);
			if (SmallestNon10 == -1) {
				System.out.println(0);
			}else{
				System.out.println(sum - SmallestNon10);
			}
		}
	}
	

	public static int findSmallestNon10(int[] points){
		Arrays.sort(points);
		for (int i = 0; i < points.length; i++) {
			if (points[i]%10 != 0) {
				return points[i];
			}
		}
		return -1;
	}
}
