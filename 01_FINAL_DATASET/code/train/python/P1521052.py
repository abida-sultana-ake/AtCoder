# -*- coding:utf-8 -*-
D = list(map(int, input().split()))
J = list(map(int, input().split()))
ans = 0
days = 7
for tmp in range(days):
    ans += max(D[tmp], J[tmp])
print(ans)