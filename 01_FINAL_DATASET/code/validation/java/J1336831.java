import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayDeque;

class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		for(int i = 0;i < 12;i++){
			String[] s = br.readLine().split("");
			for(int j = 0;j < s.length;j++){
				if(s[j].equals("r")){
					count += 1;
					break;
				}
			} 
		}
		System.out.println(count);
	}
}