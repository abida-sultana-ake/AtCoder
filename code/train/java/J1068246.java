import java.util.Scanner;

public class Main {
	//問題：タテナガ
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int h=sc.nextInt();
		int w=sc.nextInt();
		System.out.println("");

		for(int i=0;i<h;i++){
			String s= sc.next();
			System.out.println(s);
			System.out.println(s);
		}
	}
	/*

入力する値↓

9 20
.....***....***.....
....*...*..*...*....
...*.....**.....*...
...*.....*......*...
....*.....*....*....
.....**..*...**.....
.......*..*.*.......
........**.*........
.........**.........


	 */
}