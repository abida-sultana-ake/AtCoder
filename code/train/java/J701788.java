import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Main mainClass = new Main();
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int r = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        //赤が残るか
        if ((x1 - r >= x2 && y1 - r >= y2) &&
                (x1 + r <= x3 && y1 - r >= y2) &&
                (x1 - r >= x2 && y1 + r <= y3) &&
                (x1 + r <= x3 && y1 + r <= y3)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        //青が残るか

        double r1 = mainClass.calcR(x1, y1, x2, y2);
        double r2 = mainClass.calcR(x1, y1, x3, y2);
        double r3 = mainClass.calcR(x1, y1, x2, y3);
        double r4 = mainClass.calcR(x1, y1, x3, y3);

        if ( r1 <= r && r2 <= r && r3 <= r && r4 <= r){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }


    }

    private double calcR(int x1, int y1, int x2, int y2) {
        double r;

        r = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return r;
    }
}
