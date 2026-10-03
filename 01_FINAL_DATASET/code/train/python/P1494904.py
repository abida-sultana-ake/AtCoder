N, K = tuple(map(int, input().split()))
R = list(map(int, input().split()))

R.sort()
tmp = 0
for x in R[N-K:]:
    tmp = (tmp + x) / 2

print(tmp)