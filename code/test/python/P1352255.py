import numpy as np
N = int(input())
a = np.array([int(input()) for i in range(N)])
ans = 0
for n in a:
    d = (n%a==0).sum()
    aa = 1 - int(d/2) / d
    ans += aa
print(ans)