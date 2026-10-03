import numpy as np
import math

N,A,B = map(int, input().split())
h = np.zeros(N)

for i in range(N) :
    h[i] = int(input())

ans = 0
mn = 0
mx = np.ceil(h.max()/B)
now = mx//2
while (mx-mn) > 1 :
    tmp = h-B*now
    if now >= sum(np.ceil(tmp[tmp>0]/(A-B))) :
        mx = now
    else :
        mn = now

    now = (mx+mn)//2

print(int(mx))