import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static PrintWriter out = new PrintWriter(System.out);
	
	private static class NodeData {
		static NodeData[] nodes;
		static int MODULO = 1000000007;
		/** 島の番号 -1*/
		//int id;
		/** このnodeを白に塗る方法の数*/
		long white;	// 掛け算などするとintの上限を超える
		/** このnodeを黒に塗る方法の数*/
		long black;
		/** 末端はリストが空 */
		List<NodeData> childs;
		/** 頂点はparentがnull */
		NodeData parent = null;
		
		NodeData(int id) {
			//this.id = id;
			this.childs = new ArrayList<>();
			this.white = 1L;
			this.black = 1L;
		}
		
		/** aとbを相互に接続する。 */
		static void connect(int a, int b) {
			NodeData nodeA = nodes[a];
			NodeData nodeB = nodes[b];
			nodeA.childs.add(nodeB);
			nodeB.childs.add(nodeA);			
		}
		
		/** 木構造に組み替える。*/
		static void treeConnect(NodeData parent, NodeData child) {
			child.parent = parent;
			child.childs.remove(parent);
			//parent.childs.add(child);	// 既に加えられている。
		}
		
		/** 
		 * このNodeを木から除去する。
		 * 上位のNodeの値を変更する。
		 */
		void remove(){
			NodeData parent = this.parent;
			parent.childs.remove(this);
			parent.black = parent.black * this.white % NodeData.MODULO;
			parent.white = parent.white * (this.black + this.white) % NodeData.MODULO;	// 上限を超える演算はない。
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// 入力
		final int n;
		try(Scanner scan = new Scanner(System.in)) {
			n = scan.nextInt();	// 2≤N≤10^5
			NodeData.nodes = IntStream.range(0, n).mapToObj(i -> new NodeData(i)).toArray(NodeData[]::new);
			for (int i = 0; i < n - 1; i++) {
				//1≤ai,bi≤N
				int a = scan.nextInt() - 1;		// 島の番号は1オリジン
				int b = scan.nextInt() - 1;
				NodeData.connect(a, b);
			}
		}		
		//System.out.println("入力完了");
		
		// 条件から木構造になっている
		// どこからでもいいので、便宜的に0を頂点とする木構造に組み換える。
		LinkedList<NodeData> queue = new LinkedList<>();
		queue.add(NodeData.nodes[0]);
		while (!queue.isEmpty()) {
			NodeData nextNode = queue.poll();
			for (NodeData child : nextNode.childs) {	// 既にnextNode.childsからparentは除かれている。
				NodeData.treeConnect(nextNode, child);
				queue.add(child);
			}
		}
		//System.out.println("木構築完了");
		/*
		 * 動的計画法でいけそう。
		 * 木のあるnodeが白であるとき、その子は白もしくは黒に塗ることができる。
		 * 従ってそのnodeを白に塗る塗り方は、その子 child_0...nについて積をとったもの
		 * pi(i=0..n)(child[i].black+child[i].white)
		 * 同様にnodeが黒であるとき、両端が黒でないということから、その子は白でなければならず、
		 * pi(i=0..n)(child[i].white)の塗り方がある。
		 */
		// treeを移動して破壊しながら計算。
		NodeData thisNode = NodeData.nodes[0];
		while (!NodeData.nodes[0].childs.isEmpty()) {
			if (thisNode.childs.isEmpty()) {	// nodes[0].childs.isEmpty()の時は呼ばれない。
				// 末端のNodeなら除去し、上位のNodeの値を変更する。
				thisNode.remove();
				// 上位のNodeに戻る。
				thisNode = thisNode.parent;
			} else {
				// 末端でなければより末端へ移動。
				thisNode = thisNode.childs.get(0);
			}
		}
		thisNode = NodeData.nodes[0];
		long result = (thisNode.white + thisNode.black) % NodeData.MODULO;
		
		out.println(result);
		out.flush();
		
	}

}
