import java.io.*;
import java.util.*;
public class Main{
public static void main(String args[]){
int n=Fs.nextInt();
long zenkai=2;
long pt=1;
long pa=1;
while(Fs.hasNext()){
long t=Fs.nextLong();
long a=Fs.nextLong();
long wa=t+a;

long sho1=pt%t==0?pt/t:pt/t+1;
long sho2=pa%a==0?pa/a:pa/a+1;
long sho=sho1>sho2?sho1:sho2;
pa=sho*a;
pt=sho*t;

zenkai=pa+pt;
}
System.out.println(zenkai);
}
}
class Fs {
    private static final InputStream in = System.in;
    private static final byte[] buffer = new byte[1024];
    private static int ptr = 0;
    private static int buflen = 0;
    private static boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }
    private static int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    private static void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
    public static boolean hasNext() { skipUnprintable(); return hasNextByte();}
    public static String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public static int nextInt() {return (int)nextLong();}
    public static long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return minus ? -n : n;
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
    public static long[] nextLongArray(int i){
        long[] result=new long[i];
        for(int j=0;j<i;j++){
            result[j]=nextLong();
        }
        return result;
    }
    public static void nextLongArray(long[]... arrays){
        for(int j=0;j<arrays[0].length;j++){
            for(long[] array:arrays){
                array[j]=nextLong();
            }
        }
    }
    public static int[] nextIntArray(int i){
        int[] result=new int[i];
        for(int j=0;j<i;j++){
            result[j]=nextInt();
        }
        return result;
    }
    public static void nextIntArray(int[]... arrays){
        for(int j=0;j<arrays[0].length;j++){
            for(int[] array:arrays){
                array[j]=nextInt();
            }
        }
    }
    static StringBuilder sb=new StringBuilder();
    public static void flush(){
        System.out.print(sb);
        sb=new StringBuilder();
    }
    public static void pr(Object[] o,String str){
        for(Object ob:o){
            sb.append(ob);
            sb.append(str);
        }
    }
    public static void pr(long[] o,String str){
        for(long ob:o){
            sb.append(ob);
            sb.append(str);
        }
    }
    public static void pr(int[] o,String str){
        for(int ob:o){
            sb.append(ob);
            sb.append(str);
        }
    }
    public static void pr(double[] o,String str){
        for(double ob:o){
            sb.append(ob);
            sb.append(str);
        }
    }
    public static void pl(Object[] o,String str){
        pr(o,str);
        pl();
    }
    public static void pl(long[] o,String str){
        pr(o,str);
        pl();
    }
    public static void pl(int[] o,String str){
        pr(o,str);
        pl();
    }
    public static void pl(double[] o,String str){
        pr(o,str);
        pl();
    }
    public static void pr(Object o){
        sb.append(o);
    }
    public static void pl(Object o){
        sb.append(o);
        sb.append("\n");
    }
    public static void pr(long o){
        sb.append(o);
    }
    public static void pl(long o){
        sb.append(o);
        sb.append("\n");
    }
    public static void pr(double o){
        sb.append(o);
    }
    public static void pl(double o){
        sb.append(o);
        sb.append("\n");
    }
    public static void pl(){
        sb.append("\n");
    }
    public static long[] prefSum(long[] la){
        long[] result=new long[la.length];
        long l=0;
        for(int i=0;i<la.length;i++){
            result[i]=l+la[i];
            l=result[i];
        }
        return result;
    }
    public static long[] prefSum(long[] la,long mod){
        long[] result=new long[la.length];
        long l=0;
        for(int i=0;i<la.length;i++){
            result[i]=(l+la[i]+mod)%mod;
            l=result[i];
        }
        return result;
    }
    public static int lastLowerIndex(long[] array,long lo){//array is sorted.
        if(array[array.length-1]<lo){return array.length-1;}
        if(array[0]>=lo){return -1;}
        int tmax=array.length-1;
        int tmin=0;
        int haba=tmax-tmin;
        int tindex=tmin+haba/2;
        while(haba>0){
            if(array[tindex]<lo){
                tmin=tindex;
            }else{
                tmax=tindex-1;
            }
            haba=tmax-tmin;
            tindex=tmin+haba/2+(haba==1?1:0);
        }
        return tindex;
    }
    public static int lastLowerOrEqualIndex(long[] array,long lo){
        if(array[array.length-1]<=lo){return array.length-1;}
        if(array[0]>lo){return -1;}
        int tmax=array.length-1;
        int tmin=0;
        int haba=tmax-tmin;
        int tindex=tmin+haba/2;
        while(haba>0){
            if(array[tindex]<=lo){
                tmin=tindex;
            }else{
                tmax=tindex-1;
            }
            haba=tmax-tmin;
            tindex=tmin+haba/2+(haba==1?1:0);
        }
        return tindex;
    }
    public static long modPow(long a,long b,long mod){
        long c=1;
        while(b>0){
            if(b%2==1){
                c=(c*a)%mod;
            }
            a=(a*a)%mod;
            b/=2;
        }
        return c;
    }
    public static long inv(long a,long mod){
       long b=mod;
       long p = 1, q = 0;
		while (b > 0) {
			long c = a / b;
			long d;
			d = a;
			a = b;
			b = d % b;
			d = p;
			p = q;
			q = d - c * q;
		}
		return p < 0 ? p + mod : p;
    }
    static long time=0;
    public static void kesoku(){
        if(time==0){
            time=System.nanoTime();
        }else{
            long t=System.nanoTime();
            pl((t-time)/1000000000.0+"sec");
            time=t;
        }
    }
}
