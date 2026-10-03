import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner(System.in);

		String n = sc.nextLine();
		sc.close();

		StringBuffer buf = new StringBuffer();
		for(int i=0; i<n.length(); i++){
			if(i%2==0){
				buf.append(n.substring(i,i+1));
			}
		}

		System.out.println(buf);
	}

}
