import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        char[] c=sc.nextLine().toCharArray();
        boolean f[]=new boolean[26];
        boolean flg=false;
        
        for(int i=0;i<f.length;i++){
            f[i]=false;
        }
        for(int i=0;i<c.length;i++){
            f[c[i]-'a']=true;
        }
        for(int i=0;i<f.length&&flg==false;i++){
            if(f[i]==false){
                System.out.println((char)(i+'a'));
                flg=true;
            }
        }
        if(flg==false){
            System.out.println("None");
        }
        
    }
    
}