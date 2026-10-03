import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Person> people = new HashMap<>();
        for (int i = 0; i < n; i++) {
            people.put(i, new Person(i));
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            Person aFriend = people.get(b);
            Person bFriend = people.get(a);
            aFriend.friendsId.add(a);
            bFriend.friendsId.add(b);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> friendsId = people.get(i).friendsId;
            Set<Integer> ids = new HashSet<>();
            for (int id : friendsId) {
                int finalI = i;
                people.get(id).friendsId.stream().filter(idx -> idx != finalI).filter(idx -> !friendsId.contains(idx)).forEach(ids::add);
            }
            System.out.println(ids.size());
        }
    }

    static class Person {
        int id;
        List<Integer> friendsId = new ArrayList<>();
        Person(int id) {
            this.id = id;
        }
    }
}