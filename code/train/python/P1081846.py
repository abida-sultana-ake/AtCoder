n = int(input())
r = list(map(int, input().split()))
d = {}
for v in r: d[v] = d.get(v, -1) + 1
s = sum(d.values())
print(n - 2*((s+1)//2))
