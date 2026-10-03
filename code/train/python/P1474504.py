# -*- coding:utf-8 -*-
L, R = map(int, input().split())
l = list(map(int, input().split()))
r = list(map(int, input().split()))
ans = 0
for tmp in l:
    if r.count(tmp) > 0:
        ans += 1
        r.pop(r.index(tmp))
print(ans)