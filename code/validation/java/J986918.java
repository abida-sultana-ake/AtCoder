import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=N;i++){
            map.put(i,sc.nextInt());
        }
        
        List<Map.Entry<Integer,Integer>> entries = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer,Integer>>() {
 
            @Override
            public int compare(
                  Entry<Integer,Integer> entry1, Entry<Integer,Integer> entry2) {
                return ((Integer)entry2.getValue()).compareTo((Integer)entry1.getValue());
            }
        });
        
        for (Entry<Integer,Integer> s : entries) {
            System.out.println(s.getKey());
        }

    }
    
    
}
