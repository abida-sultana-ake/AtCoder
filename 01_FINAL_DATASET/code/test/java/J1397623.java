import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> param = new ArrayList<String>();
		int system = 0; // 文字の空白区切り 0:ON 1:OFF

		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				num.add(sc.nextInt());
			} else {
				if (system == 0)
					param.add(sc.next());
				if (system == 1)
					param.add(sc.nextLine());
			}
		}
		Method(num, param);
	}

	static void Method(ArrayList<Integer> num, ArrayList<String> param) {
		HashMap<String,Integer> count = new HashMap<>();
		
		for(int i = 0; i < param.size(); i++){
			if(count.containsKey(param.get(i))){
				count.put(param.get(i),count.get(param.get(i))+1);
			} else {
				count.put(param.get(i),1);
			}
		}
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(count.entrySet());
		Collections.sort(list_entries,new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
		int sub = String.valueOf(list_entries.get(0)).indexOf("=");
		System.out.println(String.valueOf(list_entries.get(0)).substring(0,sub));
	}
}