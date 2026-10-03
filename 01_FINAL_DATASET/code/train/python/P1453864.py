mod = 10**9+7

H, W, A, B = list(map(int, input().split(" ")))

fact = [1] * (2 * 10**5+1)
for i in range(1, 2*10**5+1):
    fact[i] = i * fact[i-1] % mod

def comb(n, k):
    a = fact[n] % mod
    b = (fact[k] * fact[n-k]) % mod
    b_ = pow(b, mod-2, mod)
    return  (a * b_) % mod

ans = 0
for i in range(B, W):
    # (h-a+i)Ci * (a+W-i)Ca 
    ans += comb(H-A+i-1, i) * comb(A+W-i-2, A-1) % mod
    
print(ans%mod)