n, k = map(int, input().split())
r = list(map(int, input().split()))
r.sort(reverse=True)

rate = 0
for i in range(k):
    rate = (rate + r[k-i-1]) / 2
print(rate)
