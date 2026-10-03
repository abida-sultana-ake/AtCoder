import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ss0 = br.readLine().trim().split(" ", 0);
		int N = Integer.parseInt(ss0[0]);
		long T = Integer.parseInt(ss0[1]);
		
		ss0 = br.readLine().trim().split(" ", 0);
		long[] t = new long[N];
		for(int i = 0; i < N; i++){
			t[i] = Long.parseLong(ss0[i]);
		}
		
		long ans = 0;
		for(int i = 0; i < N-1; i++){
			//System.out.println("t[i]=[" + t[i] + "], t[i+1]=[" + t[i+1] + "], ans=[" + ans + "]");
			if( (t[i] + T) > t[i+1] ) {
				ans += t[i+1] - t[i];
			} else {
				ans += T;
			}
			//System.out.println("t[i]=[" + t[i] + "], t[i+1]=[" + t[i+1] + "], ans=[" + ans + "]");
			//System.out.println("");
		}
		
		ans += T;
		
        System.out.println(ans);
        return;
    }
    //-----------------------------------------------------------------
    // Debug.Print
    static void dp(String s) {
		System.out.println(s);
	}
    static void dp(StringBuilder s) { dp(s.toString()); }
    static void dp(int i) { dp(String.valueOf(i)); }
    static void dp(long i) { dp(String.valueOf(i)); }


	//-----------------------------------------------------------------
	// 入力値確認：リスト
	static void checkInput(List l) { System.out.println(l); }
	//-----------------------------------------------------------------
	// 入力値確認：配列、1次元、float型
	//   ＜使い方＞
	//     float[] f = new float[N];
	//     checkInput(f);
	static void checkInput(float[] i1) {
		StringBuilder sb = new StringBuilder();
		for(float i: i1) sb.append("[" + i + "]");
		System.out.println(sb);
	}
	//-----------------------------------------------------------------
	// 入力値確認：配列、1次元、int型
	//   ＜使い方＞
	//     int[] c = new int[N];
	//     checkInput(c);
	static void checkInput(int[] i1) {
		StringBuilder sb = new StringBuilder();
		for(int i: i1) sb.append("[" + i + "]");
		System.out.println(sb);
	}
	//-----------------------------------------------------------------
	// 入力値確認：配列、二次元、int型
	static void checkInput(int[][] i2) {
		StringBuilder sb = new StringBuilder();
		for(int[] i1: i2){
			for(int i: i1) sb.append("[" + i + "]");
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb);
	}
	//-----------------------------------------------------------------
	// 入力値確認：配列、二次元、int型
	static void checkInput(long[][] i2) {
		StringBuilder sb = new StringBuilder();
		for(long[] i1: i2){
			for(long i: i1) sb.append("[" + i + "]");
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb);
	}

}