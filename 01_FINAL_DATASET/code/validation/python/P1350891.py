W, H = map(int, input().split())
mod = 10**9+7

def pmod(x, y):
    n = 1
    while y>0:
        if y%2==1:
            n = n*x%mod
        y>>=1
        x = x*x%mod
    return n

def fmod(x):
    n = 1
    for i in range(x, 0, -1):
        n = n * i % mod
    return n

a, b = fmod(W+H-2), (fmod(W-1)*fmod(H-1))%mod
c = pmod(b, mod-2)
print((a*c)%mod)