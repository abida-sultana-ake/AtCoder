import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    private Scanner stdin = new Scanner(new BufferedInputStream(System.in));
    private PrintWriter stdout = new PrintWriter(new BufferedOutputStream(System.out));

    private void main() {
        int currentHours = stdin.nextInt();
        int contestBeginFor = stdin.nextInt();

        stdout.println((currentHours + contestBeginFor) % 24);


        stdin.close();
        stdout.close();
    }

    public static void main(String[] args) {
        Main clazz = new Main();
        clazz.main();
    }

}