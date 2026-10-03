H, W, A, B = map(int, input().split())
mod = 10**9+7
fac = [1,1]+[n[0] for n in [[1]] for s in [n.__setitem__]for i in range(2,10**5*2+1)if s(0, n[0]*i%mod) or 1]


def get_comb(n, r):
    return (fac[n] * get_inverse_element(fac[r] * fac[n-r] % mod)) % mod


def get_inverse_element(x):
    ans = 1
    for c in "101000000101001101011001110111":
        if c == "1":
            ans = ans * x % mod
        x = x * x % mod
    return ans


def pow_mod(x, y):
    n = 1
    for bit in bin(y)[:1:-1]:
        if bit == "1":
            n = n * x % mod
        x = x * x % mod
    return n

result = 0
for i in range(B+1, W+1):
    x1, y1 = i-1, H-A-1
    a = get_comb(x1+y1, x1) % mod
    x2, y2 = W-i, A-1
    b = get_comb(x2+y2, x2) % mod
    result = (result + a * b) % mod

print(result)