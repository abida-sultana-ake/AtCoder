import numpy as np
N = int(input())
s = []
for i in range(N):
    s.append(int(input()))
s = np.sort(s)
index_nonten = np.where(s%10!=0)[0]
sum = np.sum(s)
if sum%10==0:
    if len(index_nonten)==0:
        sum = 0
    else:
        sum -=s[index_nonten][0]
print (sum)