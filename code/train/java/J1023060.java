import java.util.*;
import java.io.*;
public class Main{
	static int find(int a,int parent[]){
		if(a == parent[a])return a;
		parent[a] = find(parent[a],parent);
		return parent[a];
	}
	static void merge(int a,int b,int parent[],int rank[]){
		int repa = find(a,parent);
		int repb = find(b,parent);
		if(repa == repb)return;
		if(rank[repa] > rank[repb])
			parent[repb] = repa;
		else parent[repa] = repb;
		if(rank[repa] == rank[repb])
			++rank[repb];
	}
	public static void main(String [] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int parentA[] = new int[n + 1];
		int parentB[] = new int[n + 1];
		int rankA[] = new int[n + 1];
		int rankB[] = new int[n + 1];
		for(int i = 1;i <= n;i++){
			parentA[i] = i;
			parentB[i] = i;
		}
		for(int i = 1;i <= k;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			merge(a,b,parentA,rankA);
		}
		for(int i = 1;i <= l;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			merge(a,b,parentB,rankB);
		}
		//for(int i = 1;i <= n;i++)System.out.println(i + " " + parentA[i]);
		//	for(int i = 1;i <= n;i++)System.out.println(i + " " + parentB[i]);
		HashMap<Long,Integer>map = new HashMap<>();
		for(int i = 1;i <= n;i++){
           long temp = find(i,parentA)*1L*n + find(i,parentB);
           if(map.containsKey(temp))
           	map.put(temp,map.get(temp) + 1);
           else map.put(temp,1);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i <= n;i++){
			long temp = find(i,parentA)*1L*n + find(i,parentB);
			sb.append(map.get(temp) + " ");
		}
		System.out.println(sb);
	}
}