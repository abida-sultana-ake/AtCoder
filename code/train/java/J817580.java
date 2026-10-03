import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int x, y, z;
	static Stack<Integer> stack = new Stack<Integer>();
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> seq = new ArrayList<String>();

	static void rec() {
		list = new ArrayList<String>();
		go(0, x);
		ArrayList<String> fives = new ArrayList<String>();
		for (String s : list)
			fives.add(s);
		list = new ArrayList<String>();
		go(0, y);
		ArrayList<String> sevens = new ArrayList<String>();
		for (String s : list)
			sevens.add(s);
		list = new ArrayList<String>();
		go(0, z);
		for (String s : fives) {
			for (String s2 : sevens) {
				for (String s3 : list) {
					seq.add(s + s2 + s3);
				}
			}
		}
	}

	static void go(int curr, int limit) {
		if (curr > limit)
			return;
		if (curr == limit) {
			String s = "";
			for (int x : stack) {
				s += x;
			}
			list.add(s);
			return;
		}
		for (int i = 1; i <= limit; i++) {
			stack.push(i);
			go(curr + i, limit);
			stack.pop();
		}
	}

	static class Node {
		int id;
		Node fail;
		Node[] child;
		boolean isTerminal;
		boolean[] chars;

		public Node() {
			child = new Node[10];
			chars = new boolean[10];
			id = -1;
		}

		void insert(String str, int index, int charIndex) {
			if (charIndex == str.length())
				isTerminal = true;
			else {
				if (child[str.charAt(charIndex) - '0'] == null) {
					child[str.charAt(charIndex) - '0'] = new Node();
					chars[str.charAt(charIndex) - '0'] = true;
				}
				child[str.charAt(charIndex) - '0'].insert(str, index,
						charIndex + 1);
			}
		}
	}

	static Node build(ArrayList<String> words) {
		Node root = new Node();
		for (int i = 0; i < words.size(); i++)
			root.insert(words.get(i), i, 0);
		Queue<Node> q = new LinkedList<Node>();
		for (int i = 0; i < 10; i++) {
			if (root.child[i] == null)
				root.child[i] = root;
			else {
				q.add(root.child[i]);
				root.child[i].fail = root;
			}
		}
		while (!q.isEmpty()) {
			Node front = q.remove();
			for (int i = 0; i < 10; i++) {
				if (!front.chars[i])
					continue;
				q.add(front.child[i]);
				Node temp = front.fail;
				while (temp.child[i] == null)
					temp = temp.fail;
				temp = temp.child[i];
				front.child[i].fail = temp;
				front.child[i].isTerminal |= temp.isTerminal;
			}
		}
		return root;
	}

	public static void dfs(Node n) {
		if (n.id != -1)
			return;
		n.id = id;
		nodes[id++] = n;
		for (int i = 0; i < 10; i++)
			if (n.chars[i]) {
				dfs(n.child[i]);
			}
	}

	static int id, n;
	static Node[] nodes = new Node[50000];
	static Integer[][][] dp = new Integer[40][50000][2];
	static int mod = 1000000007;

	public static int go(int index, int nodeId, int flag) {
		if (index == n) {
			return flag == 1 ? 1 : 0;
		}
		if (dp[index][nodeId][flag] != null)
			return dp[index][nodeId][flag];
		int res = 0;
		for (char c = '0'; c <= '9'; c++) {
			Node n = nodes[nodeId];
			while (n.child[c-'0'] == null)
				n = n.fail;
			n = n.child[c-'0'];
			res += go(index + 1, n.id, flag | (n.isTerminal ? 1 : 0));
			res %= mod;
		}
		return dp[index][nodeId][flag] = res;
	}

	public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		n = r.nextInt();
		x = r.nextInt();
		y = r.nextInt();
		z = r.nextInt();
		rec();
		Node root = build(seq);
		dfs(root);
		System.out.println(go(0, 0, 0));
	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
