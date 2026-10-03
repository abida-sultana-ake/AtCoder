import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		int Sx = scan.nextInt();
        int Sy = scan.nextInt();
        int Tx = scan.nextInt();
        int Ty = scan.nextInt();
        int a = Tx-Sx;
        int b = Ty-Sy;
       R(a);
       U(b);
       L(a);
       D(b+1);
       R(a+1);
       U(b+1);
       L(1);
       U(1);
       L(a+1);
       D(b+1);
       R(1);
	}
	public static void R(int i){
		for(int n=0;n<i;n++){
		System.out.print('R');
		}
	}
	public static void L(int i){
			for(int n=0;n<i;n++){
			System.out.print('L');
			}
	}
	public static void D(int i){
		for(int n=0;n<i;n++){
		System.out.print('D');
		}
}
	public static void U(int i){
		for(int n=0;n<i;n++){
		System.out.print('U');
		}
}
	
}