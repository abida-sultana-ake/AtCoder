import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int yonbai=0,kisuu=0,guusuu=0;
		
		for(int i=0; i<n; i++){
			int a = sc.nextInt();
			if(a % 4 == 0){
				yonbai++;
			}
			else if(a % 2 != 0){
				kisuu++;
			}
			else{
				guusuu++;
			}
		}
		
		
		//System.out.println("yonbai:" + yonbai + "kisuu:" + kisuu + "guusuu" + guusuu);
		
		if(yonbai >= kisuu){
			System.out.println("Yes");
		}
		else if(yonbai == kisuu - 1 && guusuu == 0){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}