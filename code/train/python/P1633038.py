N = int(input())
a = list(map(int, input().split()))
if sum(a) % N:
    print(-1)
else:
    k = sum(a) // N
    ret = 0
    for i in range(N - 1):
        ret += 1 if a[i] != k else 0
        a[i + 1] += a[i] - k
    print(ret)