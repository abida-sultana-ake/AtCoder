N = int(input())

T = [int(input()) for _ in range(N)]
ret = float('inf')
for i in range(1 << 4):
    l = 0
    r = 0
    k = i
    for t in T:
        if k % 2:
            l += t
        else:
            r += t
        k //= 2
    ret = min(ret, max(l, r))
print(ret)
