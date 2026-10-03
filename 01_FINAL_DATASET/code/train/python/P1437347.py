def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def rls(): return list(input())
def pli(a): return "".join(list(map(str, a)))

import math

N = ri()
r = []
for i in range(N):
    r.append(ri())

r.sort(reverse=True)
ans = 0
for i in range(N):
    sign = 1 if i%2 == 0 else -1
    ans += r[i]**2*math.pi*sign
print(ans)