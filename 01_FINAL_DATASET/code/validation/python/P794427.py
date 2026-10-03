N = int(input())
d = {}
a = list(map(int, input().split()))

for i in range(N):
    d[a[i]] = i

for k in sorted(d.keys(), reverse=True):
    print(d[k] + 1)