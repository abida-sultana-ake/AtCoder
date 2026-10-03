

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Main().start();
	}
	void start(){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length()/2-1;
		for(int i = n; i > 0; i-=1){
			if(isDouble(s,i)){
				System.out.println(i*2);
				break;
			}
		}
		in.close();
	}
	boolean isDouble(String s, int n){
		for(int i = 0; i < n; i++){
			if(s.charAt(i) != s.charAt(n+i)) return false;
		}
		return true;
	}

}
