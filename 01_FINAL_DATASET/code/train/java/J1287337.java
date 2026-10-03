import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Nacl nacl = new Nacl(new Scanner(System.in));
		System.out.println(nacl.main());
	}

}
class Nacl{

	int N,K;
	double[] w,p;
	boolean[] used;

	Nacl(Scanner scan){
		N=scan.nextInt();
		K=scan.nextInt();
		used=new boolean[N];
		w=new double[N];
		p=new double[N];
		for(int i=0;i<N;i++){
			w[i]=(double)scan.nextInt();
			p[i]=(double)scan.nextInt();
			}
	}
	double main(){

		double sumW=0;
		double maxp=0;
		double maxp_;
		int maxid=0;
		for(int i=0;i<K;i++){
			maxp_=0;//今のループの最大濃度をリセット
			for(int j=0;j<N;j++){
				if(!used[j]){
					double nd=(sumW*maxp+w[j]*p[j])/(sumW+w[j]);//溶液jを入れた時の濃度
					if(nd >maxp_){
						maxid=j;
						maxp_=nd;
					}
				}
			}
			used[maxid]=true;
			sumW+=w[maxid];
			maxp=maxp_;
		}
		return maxp;

	}

}
//同じ濃度が複数ある時はどうするか？→貪欲的に試しているから多分変わらない