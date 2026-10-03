# coding: utf-8
# Here your code !
from collections import Counter
def ILSNRows(N): return [input() for i in range(N)]
n=int(input())
lis =ILSNRows(n)
counter = Counter(lis)
for word, cnt in counter.most_common(1):
    print(word)