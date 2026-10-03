import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

    public class Main {

        static long mod = 1000000007;
        static class Takahashi {
            private int x;
            private int y;
            private int c;
            public int getX() {
                return x;
            }
            public void setX(int x) {
                this.x = x;
            }
            public int getY() {
                return y;
            }
            public void setY(int y) {
                this.y = y;
            }
            public int getC() {
                return c;
            }
            public void setC(int c) {
                this.c = c;
            }
        }
        public static void main(String[] args) throws IOException{
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int t = sc.nextInt();
            int x = 0, y = 0, q = 0;
            
            for(int i = 0;i<s.length();i++){
            	switch (s.charAt(i)){
            	case 'L':
            		x--;
            		break;
            	case 'R':
            		x++;
            		break;
            	case 'U':
            		y--;
            		break;
            	case 'D':
            		y++;
            		break;
            	case '?':
            		q++;
            		break;
            	}
            }
            
           if(t==1){
        	   while(q>0){
        		   if(x>0){
        			   x++;
        		   }else{
        			   x--;
        		   }
        		   q--;
        	   }
        	  System.out.println(Math.abs(x)+Math.abs(y)); 
           }else{
        	   if(Math.abs(x)+Math.abs(y) >= q){
        		   System.out.println(Math.abs(x)+Math.abs(y)-q);
        	   }else{
        		   System.out.println((q-Math.abs(x)-Math.abs(y)) % 2);
        	   }
           }
            
            
           
//            int x[] = new int[n];
//            int y[] = new int[n];
//            int c[] = new int[n];
  




            sc.close();

                 }

        static double time(int x,int y,int c,double destx,double desty){
            double time;
            time = c * Math.max(Math.abs(x-destx),Math.abs(y-desty));
            return time;

        }
        static long fact(int n) {
            if(n==1) return 1;
            else     return n * fact(n-1);
        }

        static long permutation(int n,int m) {
            if((n==1)||(n==m)) return 1;
            else     return n * permutation(n-1,m);
        }

        static int calc(int a,int b,int p){
            if(b==0) return 1;
            if(b%2==0){
                int d = calc(a,b/2,p);
                return (d*d) % p;
            }else{
                return (a * calc(a,b-1,p));
            }
        }
    }
