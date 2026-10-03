import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static int max = 0;
    public static List<Relation> relations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        for (int i : IntStream.range(0, M).toArray()){
            relations.add(new Relation(scan.nextInt(), scan.nextInt()));
        }
        search(new ArrayList<>(), 1, N);
        System.out.println(max);
    }

    public static void search(List<Integer> group, int x, int y) {
        if(x > y) {
            return;
        }
        search(group, x + 1, y);
        if(hasRelations(group, x)) {
            group.add(x);
            max = Math.max(max, group.size());
            search(group, x + 1, y);
            group.remove(Integer.valueOf(x));
        }

    }

    public static boolean hasRelations(List<Integer> group, int x) {
        for(int y : group) {
            boolean flag = false;
            for(Relation e : relations) {
                if((e.a == x && e.b == y) || (e.a == y && e.b == x)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    static class Relation{
        int a;
        int b;

        public Relation(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}