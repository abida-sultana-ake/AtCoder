from collections import Counter
L,R = map(int,input().split())
ls = list(map(int,input().split()))
rs = list(map(int,input().split()))

cl = Counter(ls)
cr = Counter(rs)

ans = 0
for size,l in cl.items():
    ans += min(l, cr[size])
print(ans)
