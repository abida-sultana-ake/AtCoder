import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        Integer[] array = (Integer[])list.toArray(new Integer[0]);
        Arrays.sort(array, 1, array.length);
        
        System.out.println(array[1]);
        
    }
    
}
