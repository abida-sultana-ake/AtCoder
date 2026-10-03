from bisect import bisect

N = int(input())
c = []
for i in range(N):
    c.append(int(input()))
INF = 10**9+7
queue = [c[0]]

for i in range(1,N):
    if queue[-1] < c[i]:
        queue.append(c[i])
    else:
        n = bisect(queue,c[i])
        queue[n] = min(queue[n],c[i])

print(N - len(queue))
    
