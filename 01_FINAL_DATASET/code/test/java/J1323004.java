import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if(a + b >= 10){
        	System.out.println("error");
        }else{
        	System.out.println(a+b);
        }
	}

}
