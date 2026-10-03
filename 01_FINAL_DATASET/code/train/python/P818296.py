C = int(1e9) + 7
h, w, a, b = [int(x) for x in input().split()]

fact = [1]
for x in range(1, h + w - 2):
    fact.append((x * fact[x - 1]) % C)

factinv = [1] * (h + w - 2)
factinv[h + w - 3] = pow(fact[h + w - 3], C - 2, C)
for x in reversed(range(2, h + w - 3)):
    factinv[x] = (factinv[x + 1] * (x + 1)) % C

def nCr(n, r):
    return (fact[n] * factinv[r] * factinv[n - r]) % C

ans = 0
for i in range(b, w):
    ans = (ans + nCr(i + h - a - 1, h - a - 1) * nCr(a - 1 + w - i - 1, a - 1)) % C

print(ans)
