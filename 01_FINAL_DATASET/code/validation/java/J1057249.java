import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int tx = sc.nextInt();
        int ty = sc.nextInt();
        String firstRound = getShortestPathToGo(sx, sy, tx, ty);
        String secondRound = getShortestPathToBack(sx, sy, tx, ty);
        String thirdRound = "D" + getShortestPathToGo(sx, sy-1, tx+1, ty) + "L";
        String fourthRound = "U" + getShortestPathToBack(sx-1, sy, tx, ty+1) + "R";
        System.out.println(firstRound + secondRound + thirdRound + fourthRound);
    }

    public static String getShortestPathToGo(int sx, int sy, int tx, int ty) {
        String path = "";
        for(int i = 0; i < tx - sx; i++) {
            path += "R";
        }
        for(int j = 0; j < ty - sy; j++) {
            path += "U";
        }
        return path;
    }

    public static String getShortestPathToBack(int sx, int sy, int tx, int ty) {
        String path = "";
        for(int i = 0; i < tx - sx; i++) {
            path += "L";
        }
        for(int j = 0; j < ty - sy; j++) {
            path += "D";
        }
        return path;
    }
}