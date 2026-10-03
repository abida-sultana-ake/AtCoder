public class Main{
    public static void main(String[]args){

        // int n = new java.util.Random().nextInt(10);
        // int arrays[] =new int[n];
        // for(int i=0;i<=n;i++){
        //     int r = new java.util.Random().nextInt(10);
        //     arrays[i] = r;
        // }
        // System.out.println(arrays);

        String s  =new java.util.Scanner(System.in).next();
        int n = s.length();
       // System.out.println(s.substring(0,1));//文頭
        String a = s.substring(0,1);//0,1の間を取得
        String b = s.substring(n-1);

        System.out.println(a+(n-2)+b);
        // System.out.println(a);
     }
}