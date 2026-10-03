# coding: utf-8
# Here your code !
from collections import Counter
import sys
n=int(input())
a,b=list(map(int, input().split()))
k=int(input())
p = list(map(int, input().split()))
p.append(a)
p.append(b)
cnt = Counter(p)
for i in cnt:
    if cnt[i]!=1:
        print("NO")
        sys.exit()
print("YES")
        