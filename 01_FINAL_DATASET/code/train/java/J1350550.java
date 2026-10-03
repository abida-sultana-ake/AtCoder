import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			ArrayList<Integer> member = new ArrayList<Integer>();
			for(int i=0; i<n; i++){
				member.add(i);
			}

			boolean[][] R = new boolean[n][n];
			for(int i =0; i<m;i++){
				String[] s = br.readLine().split(" ");
				int k = Integer.parseInt(s[0])-1;
				int l = Integer.parseInt(s[1])-1;
				R[k][l] = true;
				R[l][k] = true;
			}
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			dfs(1,member,list,R,res);
			list.remove(0);
			dfs(1,member,list,R,res);
			
			int max =0;
			for(int i=0; i<res.size();i++){
				max = Math.max(max,res.get(i).size());
			}
			System.out.println(max);
	}


	static void dfs(int i, ArrayList<Integer> memberList, ArrayList<Integer> list, boolean[][] Relational,ArrayList<ArrayList<Integer>> result){
		
		
		if(i == n){
			result.add(new ArrayList<Integer>(list));
			return;
		}

		boolean isOk=true;
		for(int k : list){
		isOk = isOk && Relational[k][i];												
		}

		dfs(i+1,memberList,list,Relational,result);

		if(isOk){
			list.add(memberList.get(i));
			dfs(i+1,memberList,list,Relational,result);
			list.remove(list.size() - 1);
		}
	}
}