from collections import Counter

n = int(input())
s = [input() for i in range(n)]
cs = [Counter(x) for x in s]
r = Counter()
res = []
for k, v in cs[0].items():
    r[k] = v
    for c in cs:
        r[k] = min(r[k], c[k])
    res += ([k] * r[k])
res.sort()
res = ''.join(res)
print(res)
