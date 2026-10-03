N, K = map(int, input().split())
a = [tuple(map(int, input().split())) for _ in range(N)]
lo, hi = 0, 100
for _ in range(100):
    mi = (lo + hi) * 0.5
    if 0 < sum(sorted((mi - p) * w for w, p in a)[:K]):
        hi = mi
    else:
        lo = mi
print("{:.9f}".format(lo))