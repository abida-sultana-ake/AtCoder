from math import factorial
n = int(input())
c = [0]*n
for i in range(n):
    c[i] = int(input())
yaku = [[] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if i==j: continue
        if c[i]%c[j] == 0:
            yaku[i].append(j)

ret = 0.0
for i in range(n):
    m = len(yaku[i])
    #左に偶数枚の約数
    if m%2 == 1:
        ret += 0.5
    else:
        ret += (m+2)/(2*m+2)

print(ret)
