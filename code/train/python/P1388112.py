import sys, heapq

stdin = sys.stdin

ns = lambda: stdin.readline()
ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))

n = ni()
a = na()

ln = a[0:n]
rn = [-x for x in a[2*n: 3*n]]
heapq.heapify(ln)
heapq.heapify(rn)
ls = sum(ln)
rs = sum(rn)

lb = [ls]
rb = [rs]
for i in range(1, n+1):
    heapq.heappush(ln, a[n-1+i])
    vl = heapq.heappop(ln)
    ls = ls - vl + a[n-1+i]
    lb.append(ls)

    heapq.heappush(rn, -a[2*n-i])
    vr = heapq.heappop(rn)
    rs = rs - vr - a[2*n-i]
    rb.append(rs)

ans = -float('inf')
for i in range(n+1):
    ans = max(ans, lb[i] + rb[n-i])

print (ans)