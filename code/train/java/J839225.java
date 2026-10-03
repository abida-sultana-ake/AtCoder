import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main{
    static String ans = "";
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] c = str.toCharArray();
        for(int i=0;i<c.length;i++){
           solve(c[i]);
        }
        System.out.println(ans);
    }

    static void solve(char x){
        switch(x){
        case '0':
            ans += "0";
            break;
        case '1':
            ans += "1";
            break;
        case 'B':
            if(ans.length() == 0)break;
            ans = ans.substring(0,ans.length()-1);
        }
    }
}