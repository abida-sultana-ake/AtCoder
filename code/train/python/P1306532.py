from heapq import heapify, heappushpop

n = int(input())
aa = list(map(int, input().split()))

former = aa[:n]
latter = [-a for a in aa[2 * n:]]
fs = sum(former)
ls = sum(latter)
heapify(former)
heapify(latter)

results = [0] * (n + 1)
results[0] = fs
results[-1] = ls

for i in range(n, 2 * n):
    a = aa[i]
    k = heappushpop(former, a)
    fs += a - k
    results[i - n + 1] += fs

for i in range(2 * n - 1, n - 1, -1):
    a = -aa[i]
    k = heappushpop(latter, a)
    ls += a - k
    results[i - n] += ls

print(max(results))
