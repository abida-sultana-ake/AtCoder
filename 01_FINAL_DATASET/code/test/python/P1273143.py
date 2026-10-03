N, K = list(map(int, input().split()))
S = [int(input()) for _ in range(N)]
if 0 in S:
    print(N)
    exit()

_mul = 1
l = r = 0

res = 0
while l < N:

    if r < N and (_mul * S[r] <= K or l >= r):
        _mul *= S[r]
        r += 1
    else:
        _mul //= S[l]
        l += 1
    if _mul <= K and l < r:
        # print(l, r, _mul)
        res = max(res, r - l)
print(res)
