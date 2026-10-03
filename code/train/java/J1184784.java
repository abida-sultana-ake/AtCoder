import java.util.Scanner;

public class Main {

    static int a[] =new int [1000001] ;

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();

    a[1]=0;a[2]=0;a[3]=1;
    for (int i = 3; i <1000001 ; i++) {
        a[i]=-1;
    }


    System.out.println(t(n));


    }

    static int t(int n){

    if(n==2||n==1) return 0;
    if(n==3) return 1;


    if(a[n]==-1){
        int nn=(t(n-1)+t(n-2)+t(n-3))%10007;
        a[n]=nn;
        return nn;
    }else
        return a[n];
    }


}