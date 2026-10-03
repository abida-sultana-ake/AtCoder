import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int check(int[] list) {
		boolean[] leached = new boolean[list.length];
		Arrays.fill(leached, false);
		int count=0;
		int current=0;
		while(!leached[current]) {
			// push button
			count++;
			leached[current]=true;
			current=list[current];
			if(current==1)
				return count;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] buttons_light=new int[n];
		for(int i=0; i<n; i++)
			buttons_light[i]=sc.nextInt()-1;
		sc.close();

		System.out.println(check(buttons_light));
	}
}
