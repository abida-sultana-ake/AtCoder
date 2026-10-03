import java.util.Scanner;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		ARC005ASolve solve = new ARC005ASolve();
		solve.main();
	}
}

class ARC005ASolve {
	
	int N;
	String[] words;
	
	ARC005ASolve() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.words = new String[N];
		for (int i = 0; i < N; i++) {
			String word = cin.next();
			word = word.replaceAll("\\.", "");
			words[i] = word;
		}
	}
	
	void main() {
		
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("TAKAHASHIKUN", 0);
		hash.put("Takahashikun", 0);
		hash.put("takahashikun", 0);
		
		for (String w : words) {
			if (hash.containsKey(w)) {
				hash.put(w, hash.get(w) + 1);
			} else {
				hash.put(w, 1);
			}
		}
		
		int count = 0;
		count += hash.get("TAKAHASHIKUN");
		count += hash.get("Takahashikun");
		count += hash.get("takahashikun");
		
		System.out.println(count);
	}
}
