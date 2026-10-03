n = int(input())
a = list(map(int, input().split()))
ans = 10 ** 100
p = lambda x, y: x * y >= 0
po = lambda x, y: abs(x + y) + 1 if p(x, x + y) else 0
popo = lambda x, y: -1 * x // abs(x) if p(x, x + y) else x + y


if a[0] == 0:
    s = [1, -1]
    tmpAns = [1, 1]
    for (_s, _ans) in zip(s, tmpAns):
        for i in range(1, n):
            _ans +=  po(_s, a[i])
            _s = popo(_s, a[i])
        ans = min((ans, _ans))
else:
    s = [a[0], -1 * a[0] // abs(a[0])]
    tmpAns = [0, abs(a[0]) + 1]
    for (_s, _ans) in zip(s, tmpAns):
        for i in range(1, n):
            _ans +=  po(_s, a[i])
            _s = popo(_s, a[i])
        ans = min((ans, _ans))

print(ans)
