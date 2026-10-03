import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =	new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int number = Integer.parseInt(line);
		String[] in = br.readLine().split(" ");
		ArrayList<Integer> coordinate = new ArrayList<Integer>();
		int min = 1000;
		int max =0;

		for(int i = 0; i < in.length ;i++){
			coordinate.add(Integer.parseInt(in[i]));
		}

		for(int j =0; j < coordinate.size();j++){
			if(min > coordinate.get(j)){
				min = coordinate.get(j);	//1000からmax値を下げていく
			}
			if(max < coordinate.get(j)){
				max = coordinate.get(j);	//0からmin値を上げていく
			}
		}

		System.out.println(max - min);
	}
}