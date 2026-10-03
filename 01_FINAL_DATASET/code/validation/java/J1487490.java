import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;


public class Main {
	public static final String EOF = System.lineSeparator();
	public static long l=0,l2=0;
	public static void main(String[] args) throws IOException {
		l = System.currentTimeMillis();
		new Main().exec();
		l2 = System.currentTimeMillis();
		
	}
	
	public void exec() throws IOException {
		InputUtil in = new InputUtil();
		PrintWriter out = new PrintWriter(System.out);
		int N = in.nextInt();
		int[] array_a = in.nextInt(new int[N]);
		int count_not_multiple_2 = 0;
		boolean exists_multiple_2 = false;
		int count_multiple_4 = 0;
		for(int a : array_a) {
			if(a%4 == 0) 
				count_multiple_4 ++;
			else if(a%2 == 0)
				exists_multiple_2 = true;
			else 
				count_not_multiple_2 ++;
		}
		if(exists_multiple_2){
			if(count_not_multiple_2 <= count_multiple_4) {
				out.println("Yes");
			}else{
				out.println("No");
			}
		}else{
			if(count_not_multiple_2 <= count_multiple_4 + 1 ) {
				out.println("Yes");
			}else{
				out.println("No");
			}
		}
		out.flush();
	}
	
}


class InputUtil {
	//Static Fields
	private static final int BUFSIZ = 100000;
	
	//Fields
	protected InputStream in;
	private char[] buf = null;
	private int ptr = 0;
	private int max = -1;
	private BufferedReader br = null;
	
	//Constructors
	public InputUtil() {this(System.in,BUFSIZ);}
	public InputUtil(InputStream in, int bufsiz) {
		initBuf(bufsiz);
		initIn(in);
	}
	
	//Methods
	//Initializer
	protected void initIn(InputStream in) {br = new BufferedReader(new InputStreamReader(this.in = in));}
	protected void initBuf(int bufsiz) {buf = new char[bufsiz];}
	
	//buffer operation
	private void next() throws IOException {ptr++; readBuf();}
	private void readBuf() throws IOException {
		if(ptr >= max && br.ready()) {
			if(max>0) Arrays.fill(buf,0,max,(char)0);
			max = br.read(buf);
			ptr = 0;
		}
	}
	
	//Number Input Reader/Parser
	private boolean isNum(char b) {return '0' <= b && b <= '9'; }
	private boolean isMinus(char b) {return b=='-'; }

	private int _nextInt() throws IOException {
		int sign = 1;
		int res = 0;
		char c;
		while (!isNum(c=buf[ptr]) && !isMinus(c)) 
			next();
		if (isMinus(buf[ptr])) {
			sign = -1;
			next();
		}
		while (isNum(c=buf[ptr])) {
			res *= 10;
			res += c - '0' ;
			next();
		}
		next();
		return sign * res;
	}
	
	public int nextInt() throws IOException {
		readBuf();
		return _nextInt();
	}

	public int[] nextInt(int[] result) throws IOException {
		readBuf();
		for(int i=0; i<result.length; i++) {
			result[i] = _nextInt();
		}
		return result;
	}
	
	//Close 
	public void close() throws IOException {
		if(!this.in.equals(System.in)) 
			this.in.close();
	}

}