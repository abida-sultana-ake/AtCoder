import java.util.Scanner;

public class Main {

    private int before, after, sold = 0, left = 0, stock;

    public boolean can_sell(){
        if (stock / before > 0) return true;
        else return false;
    }

    public void sell(){
        sold += (stock / before) * after;
        left += stock % before;
        stock = (stock / before) * after;
    }

    public boolean stock_available(){
        if (left > 0) return true;
        else return false;
    }

    public void add_stock(){
        stock += left;
        left = 0;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main c = new Main();
        c.before = sc.nextInt();
        c.after = sc.nextInt();
        c.stock = sc.nextInt();
        c.sold += c.stock;
        while (true){
            if (c.can_sell()){
                c.sell();
            }
            else{
                if (c.stock_available()){
                    c.add_stock();
                }
                else{
                    break;
                }
            }
        }
        System.out.println(c.sold);
    }
}
