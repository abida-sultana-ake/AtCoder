from itertools import *
n,m=map(int,input().split())
s={}
for x in chain(reversed([int(input()) for i in range(m)]),[i+1 for i in range(n)]):
 if x not in s: print(x)
 s[x]=1