# coding: utf-8

n = int(input())
a = list(map(int, raw_input().split()))

a.sort()

ans = 1000000007
for x in range(a[0], a[n - 1]):
    keep = 0
    for i in range(n):
        keep += (a[i] - x) * (a[i] - x)
    ans = min(keep, ans)

if a[0] == a[n - 1]:
    ans = 0
print(ans)