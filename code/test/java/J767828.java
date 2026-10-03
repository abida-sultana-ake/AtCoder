import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer,String> pianoKey = new HashMap<Integer,String>();
    	
    public static void main(String[] args) {
    	createKey();
    	Scanner sc = new Scanner(System.in);
    	String in = sc.nextLine();
    	char[] a = in.toCharArray();
    	int firstMiFaPos = in.indexOf("WBWBWBW");
    
    	String secondString = new String();
    	int startKey = 5;
    	StringBuffer sb = new StringBuffer();
    	for (int i = firstMiFaPos; i < a.length;i++) {
    		String key = Character.toString(a[i]);
    		sb.append(pianoKey.get(startKey));
    		startKey++;
    		if (startKey > 11){
    			startKey = 0;
    		}
    	}
    	List<String> keyList = new ArrayList<String>();
    	int secondKey = 4;
    	int secondStart = firstMiFaPos - 1;
    	for (int j = secondStart; j >= 0; j--) {
    		
    		String keyC = pianoKey.get(secondKey);
    		keyList.add(keyC);
    		secondKey--;
    		if (secondKey < 0){
    			secondKey = 11;
    		}
    	}
    	if (keyList.size() >0) {
    		System.out.println(keyList.get(keyList.size()-1));
    	} else {
    		String answer = sb.toString().substring(0,2);
    		System.out.println(answer);
    	}
    	
   		sc.close();
   	}
	
   	private static void createKey() {
   		pianoKey.put(new Integer(0),"Do");
    	pianoKey.put(new Integer(1), "Do#");
    	pianoKey.put(new Integer(2),"Re");
    	pianoKey.put(new Integer(3), "Re#");
    	pianoKey.put(new Integer(4),"Mi");
    	pianoKey.put(new Integer(5),"Fa");
    	pianoKey.put(new Integer(6), "Fa#");
    	pianoKey.put(new Integer(7), "So");
    	pianoKey.put(new Integer(8),"So#");
    	pianoKey.put(new Integer(9), "La");
    	pianoKey.put(new Integer(10), "La#");
    	pianoKey.put(new Integer(11), "Si");
    }

}
