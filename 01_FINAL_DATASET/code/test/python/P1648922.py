import heapq

N = int(input())
a = [int(n) for n in input().split()]
former = a[:N]

heapq.heapify(former)

former_sum = [sum(former)]


for k in range(N):
  heapq.heappush(former, a[N+k])
  former_sum.append(former_sum[k]+a[N+k]-heapq.heappop(former))

a = [n * (-1) for n in a]
latter = a[2*N:]
heapq.heapify(latter)
latter_sum = [sum(latter)]

for k in range(N):
  heapq.heappush(latter, a[2*N-k-1])
  latter_sum.append(latter_sum[k] + a[2*N-k-1] - heapq.heappop(latter))

res = [former_sum[k] + latter_sum[N-k] for k in range(N+1)]

print(max(res))