import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        List<Time> rainy = new ArrayList<>();
        scan.useDelimiter("[-\n]");
        for (int i : IntStream.range(0, N).toArray()) {
            int start = getStart(scan.nextInt());
            int finish = getFinish(scan.nextInt());
            rainy.add(new Time(start, finish));
        }
        rainy.sort(Comparator.comparingInt(x -> x.start));
        int start = rainy.get(0).start;
        int finish = rainy.get(0).finish;

        for (int i = 1; i < N; i++) {
            if(rainy.get(i).start <= finish) {
                finish = Math.max(finish, rainy.get(i).finish);
                continue;
            }
            System.out.println(String.format("%04d-%04d", start, finish));
            start = rainy.get(i).start;
            finish =  rainy.get(i).finish;
        }
        System.out.println(String.format("%04d-%04d", start, finish));
    }

    public static int getStart(int timeStamp) {
        return timeStamp - timeStamp % 5;
    }

    public static int getFinish(int timeStamp) {
        int tmp = timeStamp - timeStamp % 5 + (timeStamp % 5 != 0 ? 5: 0);
        tmp = tmp % 100 == 60 ? tmp + 40 : tmp;
        return tmp;
    }

    static class Time{
        int start;
        int finish;

        public Time(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
