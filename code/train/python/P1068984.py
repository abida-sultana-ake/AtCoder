# -*- coding: utf-8 -*-
# problem C

N = int(input())
ls = list(map(int, input().split()))
ls.append(0)

c = 1
ans = 0

# n >= 1
def count_fun(n):
    x = 0
    for i in range(n + 1):
        x += i
    return(x)
        
for i in range(1, N+1):
    if ls[i] > ls[i-1]:
        c += 1
    else:
        ans += count_fun(c)
        c = 1

print(ans)