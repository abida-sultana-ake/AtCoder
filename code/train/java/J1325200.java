import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] s = new int[N];
		int[] check10 = new int[N];
		for(int i=0;i<N;i++){
			s[i] = sc.nextInt();
			check10[i] = (s[i]%10==0)?1:0;
		}
		int ans = 0;
		sort(s,check10);
		for(int i=0;i<N;i++){
			ans += s[i];
		}
		if(ans%10 == 0){
			int now = 0;
			while(ans > 0){
				for(int i=now;i<N;i++){
					if(check10[i]%10!=1){
						System.out.println((ans-s[i]));
						return;
					}
				}
				ans = ans - s[now];
				now++;
			}
		}
		System.out.println(ans);
	}

	public static void sort(int[] list,int[] check){
		for(int i=0;i<list.length-1;i++){
			for(int j=i+1;j<list.length;j++){
				if(list[i]>list[j]){
					int swap = list[i];
					list[i] = list[j];
					list[j] = swap;
					swap = check[i];
					check[i] = check[j];
					check[j] = swap;
				}
			}
		}
	}

}
