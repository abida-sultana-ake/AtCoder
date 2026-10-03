# -*- coding:utf-8 -*-
N, T = map(int , input().split())
t = list(map(int, input().split()))
ans = 0
for tmp in range(N):
    if tmp == 0:
        ans += T
    else:
        a = t[tmp] - t[tmp-1]
        if a < T:
            ans -= T-a
        ans += T
print(ans)