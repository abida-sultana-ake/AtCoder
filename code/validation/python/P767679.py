from functools import reduce
mod = 1000000007
modprod = lambda it: reduce(lambda x, y: x * y % mod, it, 1)
def modpow(x, e):
    result = 1
    while e > 0:
        if e & 1:
            result = result * x % mod
        e >>= 1
        x = x * x % mod
    return result
inv = lambda x: modpow(x, mod - 2)
W, H = map(int, input().split())
a = modprod(range(1, H + W - 1))
b = modprod(range(1, H))
c = modprod(range(1, W))
print(a * inv(b) * inv(c) % mod)