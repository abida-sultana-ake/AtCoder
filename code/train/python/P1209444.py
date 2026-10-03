n, m = map(int, input().split())
xs = list(map(int, input().split()))
ys = list(map(int, input().split()))

MOD = int(1e9) + 7

def fn(ls):
    l = len(ls)
    ret = 0
    for i in range(l):
        c = l - 1 - 2 * i
        ret += c * ls[l-i-1]
        ret %= MOD
    return ret

x = fn(xs)
y = fn(ys)
ans = x * y % MOD
print(ans)
