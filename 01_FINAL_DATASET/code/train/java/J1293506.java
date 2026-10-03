import java.util.Scanner;

public class Main {

	static double A;
	static double B;
	static double C;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan=new Scanner(System.in);
		A=(double)scan.nextInt();
		B=(double)scan.nextInt();
		C=(double)scan.nextInt();

		double left=0;
		double right=1/(2*C);
		if(!(f(left)<100&&f(right)>=100)){
			left=1/(2*C);
			right=3/(2*C);
			double k=1;
			while((f(left)-100)*(f(right)-100)>0){
				k+=2;
				left=k/(2*C);
				right=(k+2)/(2*C);
			}
		}

		double half=(left+right)/2;

		for(int i=0;i<30;i++){
			if((f(left)-100)*(f(half)-100)>0){
				//leftとhalfが同じ側にある
				left=half;
			}else{
				right=half;
			}
			half=(left+right)/2;
		}
		System.out.println(half);

	}

	static double f(double t){
		return A*t+B*Math.sin(C*t*Math.PI);
	}

}
