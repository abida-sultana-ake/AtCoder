input()
L=[ int(x) for x in input().split() ]
R=[ int(x) for x in input().split() ]
a=[0]*101
b=[0]*101
for x in L: a[x] += 1
for x in R: b[x] += 1
ans = 0
for i in range(101):
  ans += min(a[i], b[i])
print(ans)