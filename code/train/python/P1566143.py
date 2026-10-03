MOD = 1000000007
kaijo = []
kaijo_1 = []

def power(a, n):
    if (n == 0):
        return 1
    res = 1
    while (n > 0):
        if ((n & 1) == 1):
            res = res * a % MOD
        a = a * a % MOD
        n >>= 1
    
    return res    

def calcKaijo():
    kaijo.append(1)
    for i in range(1, 200001):
        kaijo.append((kaijo[i - 1] * i) % MOD)

def calcKaijo_1():
    for i in range(200001):
        kaijo_1.append(0)
    kaijo_1[200000] = power(kaijo[i], MOD - 2)
    for i in range(199999, -1, -1):
        kaijo_1[i] = kaijo_1[i + 1] * (i + 1) % MOD

def comb(n, r):
    return kaijo[n] * kaijo_1[n - r] * kaijo_1[r]

calcKaijo()
calcKaijo_1()
h, w, a, b = [int(i) for i in input().split()]
count = 0
for i in range(b, w):
    count += comb(h - a - 1 + i, i) * comb(a - 1 + w - 1 - i, w - 1 - i)
    count %= MOD

print(count)