import java.util.*;

public class Main {
	static final Scanner s = new Scanner(System.in);
	public static void main(String args[]){
		int n=s.nextInt(),result=0;
		for(int i=0;i<n;i++) {
			int in = s.nextInt();
			for(;!(in%6==1||in%6==3);in--) {
				result++;
			}
		}
		System.out.println(result);
	}
}
