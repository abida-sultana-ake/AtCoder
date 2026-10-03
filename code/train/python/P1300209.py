import heapq

n = int(input())
a = list(map(int, input().split()))
hl = a[0: n]
hr = [-x for x in a[2*n: 3*n]]
heapq.heapify(hl)
heapq.heapify(hr)
sl = sum(hl)
sr = sum(hr)

bl = [sl]
br = [sr]
for i in range(1, n+1):
    heapq.heappush(hl, a[n-1+i])
    vl = heapq.heappop(hl)
    sl += a[n-1+i] - vl
    bl.append(sl)

    heapq.heappush(hr, -a[2*n-i])
    vr = heapq.heappop(hr)
    sr += -a[2*n-i] - vr
    br.append(sr)

max_score = -float('inf')
for i in range(n+1):
    max_score = max(max_score, bl[i]+br[n-i])


print(max_score)
