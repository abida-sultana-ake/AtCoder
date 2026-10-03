/**
 * Created by hirahiragi on 2017/04/02.
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String [] args){
        int n=sc.nextInt();
        int a[]=new int [4];
        a[0]=n/3600;
        n%=3600;
        a[1]=n/60;
        n%=60;
        a[2]=n;
        for(int i=0;i<3;i++){
            if(a[i]<10){
                System.out.print(0);
                System.out.print(a[i]);
            }else{
                System.out.print(a[i]);
            }
            if(i==2){System.out.println();break;}
            System.out.print(':');
        }
    }
}
