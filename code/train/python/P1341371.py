n = int(input())
a = [int(i) for i in input().split() ]
a.sort()
ans = a[-1]-a[0]
print(ans)