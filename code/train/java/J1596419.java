import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int sum = 0;
		int[] x = new int[n];
		
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			if (a - x[i] <= x[i]) {
				sum += (a - x[i])*2;
			} else {
				sum += x[i]*2;
			}
		}
		
		System.out.println(sum);
		
	}
}