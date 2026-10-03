import math

def dis(x1, y1, x2, y2):
    ans = math.sqrt((x2-x1)**2+(y2-y1)**2)
    return ans

txa, tya, txb, tyb, t, v = map(int, input().split())
n = int(input())
pos = t*v
xy = []
ans = "NO"
for i in range(n):
    x, y = map(int, input().split())
    need =dis(txa, tya, x, y)+dis(x, y, txb, tyb)
    if pos >= need:
        ans = "YES"
print(ans)
