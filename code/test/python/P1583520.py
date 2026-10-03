# coding: utf-8
# Here your code !
from collections import Counter
n = int(input())
a = [int(input()) for i in range(n)]
sum =0
cnt = Counter(a)
for i in cnt:
    sum+=(cnt[i]-1)
print(sum)
