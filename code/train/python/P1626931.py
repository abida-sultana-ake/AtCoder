H,W,A,B= map(int, input().split())
mod = 10**9+7
N=W-B

g1 = [1, 1]  # 元テーブル
g2 = [1, 1]  #逆元テーブル
inverse = [0, 1]  #逆元テーブル計算用テーブル

for i in range( 2, H+W-2 ):
    g1.append( ( g1[-1] * i ) % mod )
    inverse.append( ( -inverse[mod % i] * (mod//i) ) % mod )
    g2.append( (g2[-1] * inverse[-1]) % mod )

#以下のcom関数を用いて組み合わせを計算
def com(n, r, mod):
    if ( r<0 or r>n ):
        return 0
    r = min(r, n-r)
    return g1[n] * g2[r] * g2[n-r] % mod

ANS=0

for i in range(N):
    ANS=(ANS+com(H-A-1+B,B+i, mod)*com(W+A-1-B,A+i, mod))%mod
print(ANS)
