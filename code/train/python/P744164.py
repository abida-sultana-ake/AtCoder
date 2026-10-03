n = int(input())
a = [int(i) for i in input().split(' ')]
ans = 0
t = a[0]
ti = 0
for i, n in enumerate(a):
    if t < n:
        ti += 1
    else:
        ti = 0
    ans += 1 + ti
    t = n
print(ans)