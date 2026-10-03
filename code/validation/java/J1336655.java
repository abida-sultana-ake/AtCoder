import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayDeque;

class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String init = "b";
		int count = 0;
		boolean flag = true;
		for(int i = 1;i < (n-1) / 2 + 1;i++){
			if(i % 3 == 0){
				init = "b" + init + "b";
			}else if(i % 3 == 1){
				init = "a" + init + "c";
			}else{
				init = "c" + init + "a";
			}
		}
		if(s.equals(init)){
			System.out.println(n/2);
		}else{
			System.out.println(-1);
		}

	}
}