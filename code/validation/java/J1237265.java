public class Main {
	public static void main(String[] args) {
		long X = Long.parseLong(next());
		long Y = Long.parseLong(next());
		System.out.println(Math.abs(X - Y) <= 1 ? "Brown" : "Alice");
	}

	static int NI(){
		try {
			int c=System.in.read(),r=0;
			for(;c!='-'&&(c<'0'||'9'<c);)c=System.in.read();
			if(c=='-') return -NI();
			for(;'0'<=c&&c<='9';c=System.in.read())
				r = r * 10 + c - '0';
			return r;
		} catch (Exception e) {
			return -1;
		}
	}
	static String next() {
		try {
			StringBuilder res = new StringBuilder("");
			int c = System.in.read();
			while (Character.isWhitespace(c))
				c = System.in.read();
			do {
				res.append((char) c);
			} while (!Character.isWhitespace(c = System.in.read()));
			return res.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
