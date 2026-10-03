
import java.util.*;

public class Main
{
    private final static Main main = new Main();

    public static void main(String[] args)
    {
        main.contest();
    }

    private void contest()
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(
                b/a + (b%a == 0 ? 0 : 1)
        );
    }
}
