import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int roopTimes = Integer.parseInt(sc.nextLine());
        int customerSum = 0;
        for (int i = 0; i < roopTimes; i++){
            int startCustomer = sc.nextInt();
            int endCustomer = sc.nextInt();
                    //Integer.parseInt(sc.nextLine());  //改行文字が残らないように
            customerSum += (endCustomer-startCustomer) + 1;
        }
        System.out.println(customerSum);
    }
}