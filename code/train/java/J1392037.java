import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		String str = sc.nextLine();
		String befhalf,afthalf;
		while(str.length() > 0){
			str = str.substring(0, str.length()-1);
			befhalf = str.substring(0, str.length()/2);
			afthalf = str.substring((str.length()/2), str.length());
			//System.out.println(str+" "+befhalf+" "+afthalf);
			if(befhalf.equals(afthalf)){
				System.out.println(str.length());
				str = "";
			}
		}

	}

	private static int calc(int[] a,int ans,int n) {
		int sum=a[0];
		boolean plusFlag;
		// TODO 自動生成されたメソッド・スタブ
		if(a[0] > 0){
			plusFlag = true;
		}else{
			plusFlag = false;
		}



		for(int i = 1;i<n;i++){
			sum += a[i];
			if(plusFlag){
				if(sum >= 0){
					ans += Math.abs(sum)+1;
					sum = -1;

				}
			}else{
				if(sum <= 0){
					ans += Math.abs(sum)+1;
					sum = 1;
				}
			}
			plusFlag = !plusFlag;
		}


		return ans;
	}


}