import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
 
public class Main {
    public static void main(String[] args) {
    	Main executer = new Main();
		executer.execute();
    }
    
    public void execute() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Integer numStr = Integer.valueOf(br.readLine());
			List<Integer> points = new ArrayList<Integer>();
			Integer maxPoint = 0;
			Integer answer = 0;
			
			for (int i = 1; i <= numStr ; i++) {
				Integer point = Integer.parseInt(br.readLine());
				points.add(point);
				maxPoint += point;
			}
			
			if (!isPer10(maxPoint)) {
				answer = maxPoint;
			} else {
				Collections.sort(points);
				
				Iterator<Integer> it = points.iterator();
				
				while (it.hasNext()) {
					Integer point = it.next();
					if (!isPer10(point)) {
						answer = maxPoint - point;
						break;
					}
				}
			}
			
			System.out.println(answer);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
	}
    
    private Boolean isPer10(Integer num) {
    	return (num % 10 == 0) ? true : false;
    }
}