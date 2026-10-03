import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String onkai = "WWBWBWBW";
		String[] name = {"Fa","Fa","So","So","La","La","Si","Do","Do","Re","Re","Mi"};

		int a = line.indexOf(onkai);
		System.out.println(name[name.length-a-1]);
	}

}
