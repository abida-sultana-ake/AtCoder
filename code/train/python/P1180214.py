N, M = list(map(int, input().split()))

mvals = [list(map(int, input().split())) for _ in range(N)]
res = 0
sum_v = 0
items = [0] * (M + 2)
for l, r, v in mvals:
    items[l] += v
    items[r + 1] -= v
    sum_v += v

tmp_v = 0
for j in range(1, M + 1):
    tmp_v += items[j]
    items[j] = tmp_v
    res = max(res, sum_v - items[j])


print(res)
