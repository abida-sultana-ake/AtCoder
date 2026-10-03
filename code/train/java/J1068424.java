import java.util.Scanner;

public class Main {

	/*
	 * 問題文 日本の誇る美しいリズムとして、五七五というものがあります。
	 * いろはちゃんは五七五が大好きです。
	 *
	 * 3 つの文節の並びの長さがそれぞれ 5,7,5 となるようにこの順番で並んでいるとき、
	 * その 3 つの文節の並びは五七五であると言います。
	 *
	 * 並び替えたい 3 つの文節の長さを表す整数 A,B,C が与えられるので、
	 * それらの文節を並び替えて五七五にできるか判定してください。
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f=0;
		int s=0;
		for (int i = 0; i < 3; i++) {
			int str= sc.nextInt();
			if (str == 5) {
				f++;
			} else if(str==7){
				s++;
			}


		}
		if (s==1&&f==2) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
