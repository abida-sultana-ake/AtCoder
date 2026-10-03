from math import ceil
n = int(input())
a = list(map(int,input().split()))
r = 0
for i in a:
    if i==0: n-=1
print(int(ceil(sum(a)/n)))