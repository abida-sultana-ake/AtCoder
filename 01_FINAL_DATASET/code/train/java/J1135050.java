import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String c1 = scanner.next();
        String[] kigo = new String[16];
        for(int i = 0; i <= 15; i++){        
		    kigo[i] = scanner.next();
        }
        for (int i = 0; i <= 12; i = i + 4) {
        	int n = 12 - i;
        	System.out.println(kigo[n + 3] + " " + kigo[n + 2] + " " + kigo[n +  1] + " " + kigo[n]);
        }
//        System.out.println(kigo[15] + " " + kigo[14] + " " + kigo[13] + " " + kigo[12]);
//        System.out.println(kigo[11] + " " + kigo[10] + " " + kigo[9] + " " + kigo[8]);
//        System.out.println(kigo[7] + " " + kigo[6] + " " + kigo[5] + " " + kigo[4]);
//        System.out.println(kigo[3] + " " + kigo[2] + " " + kigo[1] + " " + kigo[0]);

    }
}