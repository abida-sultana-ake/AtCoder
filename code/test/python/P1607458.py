N = int(input())
a = list(map(int, input().split()))

a1h = a[:N]
a2h = [-ai for ai in a[2 * N:]]

import heapq
heapq.heapify(a1h)
heapq.heapify(a2h)

sum1 = [sum(a1h)]
sum2 = [sum(a2h)]
for k in range(N, 2 * N):
    sum1.append(sum1[-1] + a[k] - heapq.heappushpop(a1h, a[k]))
    sum2.append(sum2[-1] + -a[-k - 1] - heapq.heappushpop(a2h, -a[-k - 1]))

print(max(map(sum, zip(sum1, sum2[::-1]))))
