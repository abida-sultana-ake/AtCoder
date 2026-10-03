import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n];
		int[] alphabet = new int[26];
		int[] ans = new int[26];
		Arrays.fill(ans, 100);
		String trash = sc.nextLine();
		for(int i=0;i<n;i++){
			s[i] = sc.nextLine();
		}
		for(int i=0;i<n;i++){
			Arrays.fill(alphabet, 0);
			String str = s[i];
//			System.out.println("poyo"+str);
			for(int j=0;j<str.length();j++){
				char c = str.charAt(j);
				int num = (int)(c-'a');
//				System.out.println(num);
				alphabet[num]++;
			}
			for(int j=0;j<ans.length;j++){
//				System.out.println((char)('a'+j)+":"+alphabet[j]);
				ans[j] = Math.min(ans[j], alphabet[j]);
			}
		}
		for(int i=0;i<ans.length;i++){
			char c = (char)(i+'a');
			for(int j=0;j<ans[i];j++){
				System.out.print(c);
			}
		}
		System.out.println();
	}

}