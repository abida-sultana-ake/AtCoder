# -*- coding:utf-8 -*-
n = int(input())
factor = 1000000
ans = [ 0 for tmp in range(factor+1) ]
for tmp in range(n):
    a, b = map(int, input().split())
    ans[a] += 1
    if b+1 < factor+1:
        ans[b+1] -= 1
    else:
        pass
max_num = ans[0]
for tmp in range(factor):
    ans[tmp+1] += ans[tmp]
    if ans[tmp+1] > max_num:
        max_num = ans[tmp+1]
    else:
        pass
print(max_num)