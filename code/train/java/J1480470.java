import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	int n;
	int[]b;
	ArrayList<Integer>[]sub;
	int[]salary;
	void solve(){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		b=new int[n];
		sub=new ArrayList[n];
		salary=new int[n];
		for(int i=0;i<n;i++) sub[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++) b[i]=sc.nextInt()-1;
		for(int i=0;i<n-1;i++) sub[b[i]].add(i+1);
		
		System.out.println(calc(0));
	}
	int calc(int x){
		int min=Integer.MAX_VALUE/2;
		int max=0;
		if(sub[x].size()==0){
			salary[x]=1;
			return salary[x];
		}
		for(int i=0;i<sub[x].size();i++){
			int people=sub[x].get(i);
			salary[people]=calc(people);
			if(salary[people]<min)min=salary[people];
			if(salary[people]>max)max=salary[people];
		}
		salary[x]=max+min+1;
		return salary[x];
	}
}