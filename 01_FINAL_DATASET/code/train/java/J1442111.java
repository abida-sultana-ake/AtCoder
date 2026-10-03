import java.util.Scanner;

/**
 * http://abc009.contest.atcoder.jp/tasks/abc009_3
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		final int K = sc.nextInt();
		final String s = sc.next();
		sc.close();
		
		int[] cNum = new int[26];
		for(char c: s.toCharArray()) cNum[c-'a']++;
		
		String ans = "";
		int count = K;
		for( int i=0; i<N; i++){
			char currentC = s.charAt(i);
			boolean replace = false;
			for(int j=0; j<cNum.length; j++){
				cNum[j]--;
				if( cNum[j]>=0 && ( currentC == j+'a' || canReplace(s.substring(i+1, N), cNum, count-1))){
					if(currentC != j+'a') count--;
					ans +=(char)(j+'a');
					replace = true;
					break;
				}else{
					cNum[j]++;
				}
			}
			if(!replace){
				ans += currentC;
				cNum[currentC-'a']--;
			}
		}

		System.out.println(ans);

	}

	private static boolean canReplace(String substring, int[] cNum, int count) {
		int[] tmpNum = new int[26];
		for(int i=0; i<26; i++) tmpNum[i] = cNum[i];
		int replaceCount = 0;
		for(char c: substring.toCharArray()){
			if(tmpNum[c-'a']>0){
				tmpNum[c-'a']--;
			}else{
				replaceCount++;
			}
		}
		return count >= replaceCount;
	}

}