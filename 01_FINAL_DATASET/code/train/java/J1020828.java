import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int l = scan.nextInt();

		ArrayList<ArrayList<Integer>> load = new ArrayList<>(n);
		ArrayList<ArrayList<Integer>> rail = new ArrayList<>(n);
		for(int i = 0; i < n; i++) {
			load.add(new ArrayList<Integer>());
			rail.add(new ArrayList<Integer>());
		}

		for(int i = 0; i < k; i++) {
			int p = scan.nextInt()-1;
			int q = scan.nextInt()-1;
			load.get(p).add(q);
			load.get(q).add(p);
		}

		for(int i = 0; i < l; i++) {
			int p = scan.nextInt()-1;
			int q = scan.nextInt()-1;
			rail.get(p).add(q);
			rail.get(q).add(p);
		}

		boolean[] flagMap = new boolean[n];
		int groupNum = 0;
		int[] loadGroup = new int[n];
		for(int i = 0; i < n; i++) {
			int result = check(load,i,flagMap,groupNum,loadGroup);
			if(result>0) {
				groupNum++;
			}
		}

		flagMap = new boolean[n];
		groupNum = 0;
		int[] railGroup = new int[n];
		for(int i = 0; i < n; i++) {
			int result = check(rail,i,flagMap,groupNum,railGroup);
			if(result>0) {
				groupNum++;
			}
		}
/*
		for(int i = 0; i < n; i++) {
			System.out.printf("ldGrp:%d,rlGrp:%d\n",loadGroup[i],railGroup[i]);
		}
*/
		HashMap<Long,Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			long hash = getHash(railGroup[i],loadGroup[i]);
			if(map.containsKey(hash)) map.put(hash, map.get(hash)+1);
			else map.put(hash, 1);
		}

		StringBuilder sb = new StringBuilder(n*2);
		for(int i = 0; i < n; i++) {
			//System.out.println(getHash(railGroup[i],loadGroup[i]));
			sb.append(map.get(getHash(railGroup[i],loadGroup[i])));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static long getHash(int x, int y) {
		return x*1000000L+(long)y;
	}

	static int check(ArrayList<ArrayList<Integer>> list, int start, boolean[] flagMap, int groupNum, int[] group) {
		if(flagMap[start]) return 0;
		flagMap[start] = true;
		group[start] = groupNum;
		int sum = 0;
		for(int next : list.get(start)) {
			sum += check(list,next,flagMap,groupNum,group);
		}
		return 1 + sum;
	}
}
