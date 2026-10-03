import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Node2
 */
public class Main {
        Main parent;
        List<Main> children = new ArrayList();
        long num = 0;
        String str;
        static long sum = 0;
        public Main(String instr){
            str = instr;
        }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        Main tree = new Main(str);
        

        
        get(tree);
        
        System.out.println(sum);
  
    }
    public static void get(Main node){

        node.makechildren();
        
        if(node.children.isEmpty()){
            sum += node.num;
            return;
        }
        
        for(int i=0;i<node.children.size();i++){
            get(node.children.get(i));
        }
    }
  

        

        
        public void makechildren(){
            for(int i=0;i<str.length();i++){
                String buf = new String(str);
                long a = Long.parseLong(buf.substring(0, i+1));
                Main child = new Main(buf.substring(i+1));
                child.num = a + num;
                child.parent = this;
                this.children.add(child);
            }
        }
        

    
}