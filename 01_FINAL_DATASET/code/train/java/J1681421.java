import java.util.*;


public class Main {
	
	
	private void doit(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == b){
				System.out.println(c);
			}
			else if(a == c){
				System.out.println(b);
			}
			else{
				System.out.println(a);
			}
		}
	}



	private void debug(Object... o) {
		System.out.println("debug = " + Arrays.deepToString(o));
	}

	public static void main(String[] args) {
		new Main().doit();
	}

}
