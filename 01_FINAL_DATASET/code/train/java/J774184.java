import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		core(scanner);
		scanner.close();
	}

	public static void core(final Scanner in) {
		// read
		int H = in.nextInt();
		int W = in.nextInt();
		boolean[][] img = new boolean[H][W];
		for (int h = 0; h < H; h++) {
			String tmpStr = in.next();
			for (int w = 0; w < W; w++) {
				img[h][w] = (tmpStr.charAt(w) == '#');
			}
		}
		// gen
		boolean[][] orig = new boolean[H][W];
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if(1<=h){
					if(1<=w){
						if(!img[h-1][w-1]){
							orig[h][w] = false;
							continue;
						}
					}
					if(!img[h-1][w]){
						orig[h][w] = false;
						continue;
					}
					if(w<W-1){
						if(!img[h-1][w+1]){
							orig[h][w] = false;
							continue;
						}
					}
				}
				if(1<=w){
					if(!img[h][w-1]){
						orig[h][w] = false;
						continue;
					}
				}
				if(!img[h][w]){
					orig[h][w] = false;
					continue;
				}
				if(w<W-1){
					if(!img[h][w+1]){
						orig[h][w] = false;
						continue;
					}
				}
				if(h<H-1){
					if(1<=w){
						if(!img[h+1][w-1]){
							orig[h][w] = false;
							continue;
						}
					}
					if(!img[h+1][w]){
						orig[h][w] = false;
						continue;
					}
					if(w<W-1){
						if(!img[h+1][w+1]){
							orig[h][w] = false;
							continue;
						}
					}
				}
				orig[h][w] = true;
			}
		}
		//regen
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if(img[h][w]){
					if(1<=h){
						if(1<=w){
							if(orig[h-1][w-1]){
								continue;
							}
						}
						if(orig[h-1][w]){
							continue;
						}
						if(w<W-1){
							if(orig[h-1][w+1]){
								continue;
							}
						}
					}
					if(1<=w){
						if(orig[h][w-1]){
							continue;
						}
					}
					if(orig[h][w]){
						continue;
					}
					if(w<W-1){
						if(orig[h][w+1]){
							continue;
						}
					}
					if(h<H-1){
						if(1<=w){
							if(orig[h+1][w-1]){
								continue;
							}
						}
						if(orig[h+1][w]){
							continue;
						}
						if(w<W-1){
							if(orig[h+1][w+1]){
								continue;
							}
						}
					}
					System.out.println("impossible");
					return;
				}
			}
		}
		//out
		System.out.println("possible");
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				System.out.print(orig[h][w]?'#':'.');
			}
			System.out.println();
		}
	}
}
