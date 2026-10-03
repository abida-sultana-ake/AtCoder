import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main{
	
	static Scanner s=new Scanner(System.in);
	
	public static void main(String[] __){
		int n=s.nextInt();
		int[] res = new int[26],resbuf=new int[26];
		Arrays.fill(res,114514);
		for(int i=0;i<n;i++) {
			Arrays.fill(resbuf,0);
			Counter<Character> counter = new Counter<>(26);
			for(char c:s.next().toCharArray()) {
				counter.add(c);
			}
			for(Entry<Character, Integer> e:counter.map.entrySet()) {
				resbuf[e.getKey().charValue()-'a']=e.getValue();
			}
			for(int j=0;j<26;j++)
				res[j]=Math.min(res[j],resbuf[j]);
		}
		StringBuilder sb=new StringBuilder();
		for(char c='a';c<='z';c++) if(res[c-'a']!=114514){
			for(int i=0;i<res[c-'a'];i++)
				sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
class Counter<T>{
	
	public HashMap<T, Integer> map;
	
	public Counter(int initSize){
		map=new HashMap<>(initSize);
	}
	
	public Counter(){
		this(10);
	}
	
	public void add(T key, int v){
		if(!map.containsKey(key)){
			map.put(key,v);
		}else{
			map.merge(key,v,Math::addExact);
		}
	}
	
	public void add(T key){
		add(key,1);
	}
}
