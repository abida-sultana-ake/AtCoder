import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * --------------------------------------------------
 * Main Class
 * --------------------------------------------------
 */
public class Main {

	enum State {BLACK_FENNEC,WHITE_SNUKE}
	NodeUtil<State> nodeUtil = null;
	LinkedList<Node<State>> snukeNodes = new LinkedList<>();
	LinkedList<Node<State>> fennecNodes = new LinkedList<>();
	LinkedList<Node<State>> tempNodes = new LinkedList<>();
	int fennecCount = 0;
	int snukeCount = 0;

	public void exec() throws IOException {
		InputUtil input = new InputUtil();
		PrintWriter out = new PrintWriter(System.out);
		int N = input.nextInt();
		nodeUtil = new NodeUtil<>(N);
		
		State[] v = new State[N];
		v[0] = State.BLACK_FENNEC;
		v[N-1] = State.WHITE_SNUKE;
		nodeUtil.initNodeValue(v);

		int[] a = new int[N-1];
		int[] b = new int[N-1];
		for (int i=0; i<N-1; i++) {
			a[i] = input.nextInt()-1;
			b[i] = input.nextInt()-1;
		}
		nodeUtil.initPath(a, b);
		
		fennecNodes.add(nodeUtil.get(0));
		fennecCount++;
		snukeNodes.add(nodeUtil.get(N-1));
		snukeCount++;
		
		while(fennecCount + snukeCount < N){
			fennecCount += fillNode(fennecNodes, State.BLACK_FENNEC);
			snukeCount += fillNode(snukeNodes, State.WHITE_SNUKE);
		}
		out.println((fennecCount <= snukeCount)?"Snuke":"Fennec");
		out.flush();
		input.close();
	}
	
	private int fillNode(LinkedList<Node<State>> list, State state) {
		int count = 0;
		while(!list.isEmpty()) {
			Node<State> node = list.pollFirst();
			for (Node<State> conNode : node.connectedNodes ){
				if(conNode.value == null){
					conNode.value = state;
					tempNodes.add(conNode);
					count++;
				}
			}
		}
		if(!tempNodes.isEmpty()){
			list.addAll(tempNodes);
			tempNodes.clear();
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		new Main().exec();
	}
}
/**
 * --------------------------------------------------
 * Node
 * --------------------------------------------------
 */
class NodeUtil<T> {
	private List<Node<T>> nodeList = null;
	public NodeUtil(int capacity){
		nodeList = new ArrayList<>(capacity);
	}
	
	public void initNodeValue(T[] values) {
		for(int i=0; i<values.length; i++){
			nodeList.add(i,new Node<T>(values[i]));
		}
	}
	
	public void initPath(int[] pathA, int[] pathB) {
		if(pathA.length != pathB.length) 
			throw new IllegalArgumentException("different array length :pathA, pathB");
		for(int i=0; i<pathA.length; i++){
			get(pathA[i]).connectDual(get(pathB[i]));
		}
	}
	
	public Node<T> get(int index) {
		return nodeList.get(index);
	}
}

class Node<T> {
	T value = null;
	LinkedList<Node<T>> connectedNodes = new LinkedList<>();
	
	public Node(T val){value = val;}
	
	public void connectTo(Node<T> n) {
		this.connectedNodes.add(n);
	}
	
	public void connectDual(Node<T> n) {
		this.connectTo(n);
		n.connectTo(this);
	}
}


/**
 * --------------------------------------------------
 * Input Utility
 * --------------------------------------------------
 */
class InputUtil {
	//Static Fields
	private static final int BUFSIZ = 2200000;
	
	//Fields
	protected InputStream in;
	private char[] buf = null;
	private int ptr = 0;
	private int max = -1;
	private BufferedReader br = null;
	
	//Constructors
	public InputUtil() {this(System.in,BUFSIZ);}
	public InputUtil(int bufsiz) {this(System.in,bufsiz);}
	public InputUtil(InputStream in) {this(in,BUFSIZ);}
	public InputUtil(InputStream in, int bufsiz) {
		initBuf(bufsiz);
		initIn(in);
	}
	
	//Methods
	//Initializer
	protected void initIn(InputStream in) {br = new BufferedReader(new InputStreamReader(this.in = in));}
	protected void initBuf(int bufsiz) {buf = new char[bufsiz];}
	
	//String Input Reader/Parser
	private void readBuf() throws IOException {
		if(ptr >= max && br.ready()) {
			max = br.read(buf);
			ptr = 0;
		}
	}
	
	public BufferedReader getReader() {return br;}
	
	//Number Input Reader/Parser
	private boolean isNum(char b) {return '0' <= b && b <= '9'; }
	private boolean isMinus(char b) {return b=='-'; }
	private boolean isCrLf(char b) {return b == '\r' || b == '\n'; }
	private void next() throws IOException {ptr++; readBuf();}

	private void skipOneCrLf() throws IOException {
		char c = buf[ptr];
		if (isCrLf(c)) {
			ptr++;
			if (c == '\r') {
				readBuf();
				if (ptr < max && buf[ptr] == '\n') {
					ptr++;
				}
			}
		}
	}


	public String nextLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(readBuf(); ptr < max ;readBuf()) {
			char c = buf[ptr];
			if(isCrLf(c)) {
				skipOneCrLf();
				break;
			}else{
				int strPtr = ptr++;
				int endPtr = -1;
				for(int i = ptr; i<max; i++) {
					if(isCrLf(buf[i])) {
						endPtr = i;
						break;
					}
				}
				if(endPtr == -1) endPtr = max;
				sb.append(String.valueOf(buf, strPtr, endPtr-strPtr)); 
				ptr = endPtr;
			}
		}
		return sb.toString();
	}
	
	public int nextInt() throws IOException {return nextInt(new int[1])[0];}
	public int[] nextInt(int[] result) throws IOException {
		readBuf();
		for(int i=0; i<result.length; i++) {
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
			result[i] = sign * res;
		}
		return result;
	}
	
	//Close 
	public void close() throws IOException {
		if(!this.in.equals(System.in)) 
			this.in.close();
	}

}