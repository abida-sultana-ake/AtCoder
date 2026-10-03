# -*- coding:utf-8 -*-
N, M = map(int, input().split())
X, Y = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
ans = 0
factor = -Y
index = 0
for tmp in range(len(a)):
    if factor + Y <= a[tmp]:
        factor = a[tmp]
        for tmp2 in range(index,len(b)):
            if b[tmp2] >= factor+X:
                ans += 1
                factor = b[tmp2]
                index = tmp2+1
                break
print(ans)