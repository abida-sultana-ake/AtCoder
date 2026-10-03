import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		IrohaGrid iroha = new IrohaGrid();
		iroha.run();
	}
}

class IrohaGrid {
	
	int H;
	int W;
	int A;
	int B;
	
	IrohaGrid() {
		//MARK Input
		Scanner cin = new Scanner(System.in);
		this.H = cin.nextInt();
		this.W = cin.nextInt();
		this.A = cin.nextInt();
		this.B = cin.nextInt();
	}
	
	void run() {
		long mod = (long) Math.pow(10, 9) + 7;
		FermatCombination com = new FermatCombination(H + W, mod);
		
		long ans = 0;
		long n, k = 0; //nCk
		for (int i = B; i < W; i++) { // B <= i <= W -1;
			
			n = H - A - 1 + i;
			k = i;
			long tmp1 = com.combine(n, k);
			
			n = A - 1 + W - i - 1;
			k = A - 1;
			long tmp2 = com.combine(n, k);
			
			ans += tmp1 * tmp2;
			ans %= mod;
		}
		System.out.println(ans);
	}
	
	class FermatCombination {
		
		long[] factrial;
		long[] inverse;
		long MOD;
		
		FermatCombination(long size, long mod) {
			
			this.factrial = new long[(int) size + 1];
			this.inverse = new long[(int) size + 1];
			this.MOD = mod;
			
			this.factrial[0] = 1;
			this.inverse[0] = 1;
			
			for (int i = 1; i <= size; i++) {
				factrial[i] = factrial[i - 1] * i % MOD;
				inverse[i] = pow(factrial[i], (int) MOD - 2) % MOD; //フェルマーの小定理
			}
		}
		
		long combine(long n, long k) {
			return factrial[(int) n] * inverse[(int) k] % MOD * inverse[(int)n - (int)k] % MOD;
		}
		
		long pow(long x, int n) {
			long ans = 1;
			while (n > 0) {
				if ((n & 1) == 1) {
					ans = ans * x % MOD;
				}
				x = x * x % MOD;
				n >>= 1;
			}
			return ans;
		}
	}
	
}
