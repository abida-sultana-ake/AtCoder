import scipy.misc as scm

H, W, A, B = [int(i) for i in input().split()]
MOD = 10**9 + 7
f = [1]
a = [1]
for i in range(1, H+W-1):
    f.append((f[i-1] * i) % MOD)
    a.append(pow(f[i], MOD-2, MOD))
ans = 0
for i in range(B, W, 1):
    ans += (((f[(H-A-1)+i] * a[H-A-1] * a[i]) % MOD) * ((f[(A-1)+(W-1-i)] * a[A-1] * a[W-1-i]) % MOD))
    ans %= MOD
print(ans)