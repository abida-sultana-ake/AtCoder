import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		class Person {
			double x;
			double y;
			double c;
			Person(double x, double y, double c) {
				super();
				this.x = x;
				this.y = y;
				this.c = c;
			}
		}
		try(Scanner scan = new Scanner(System.in)) {
			// 入力
			int n = scan.nextInt();
			Person[] persons = new Person[n];
			for (int i = 0; i < n; i++) {
				persons[i] = new Person(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
			}
			
			//解答を見て作り直し。
			// 二分木探索で何とかなるんじゃないかと
			double maxTime = BigInteger.TEN.pow(5+3).multiply(BigInteger.valueOf(2L)).doubleValue();
			double minTime = 0D;
			double midTime = (maxTime + minTime) / 2;
			
			while (maxTime - minTime > 0.0001) {
				//各出発点から上下左右にmidTime * c 伸ばした範囲に共通部分があるか // n>=2
				final double mid = midTime;
				double xMax = Arrays.stream(persons).mapToDouble(p -> p.x + mid / p.c ).min().getAsDouble();
				double xMin = Arrays.stream(persons).mapToDouble(p -> p.x - mid / p.c ).max().getAsDouble();
				double yMax = Arrays.stream(persons).mapToDouble(p -> p.y + mid / p.c ).min().getAsDouble();
				double yMin = Arrays.stream(persons).mapToDouble(p -> p.y - mid / p.c ).max().getAsDouble();
				
				if (xMax > xMin && yMax > yMin) {
					// midTimeより小さい値でいける。
					maxTime = midTime;
					midTime = (maxTime + minTime) / 2;
				} else {
					// midTimeより大きい値でないと届かない。
					minTime = midTime;
					midTime = (maxTime + minTime) / 2;
				}
			}

			System.out.printf("%f", midTime);
			System.out.println();
		}
	}

}
