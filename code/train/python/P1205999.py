import bisect

n = int(input())
a = [int(input()) for _ in range(n)]

a.sort()
pos=bisect.bisect_left(a,a[n-1])
print(a[pos-1])
