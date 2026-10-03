from math import ceil
n,h = map(int,input().split())
a,b,c,d,e = map(int,input().split())
ret = 10**20
for i in range(n):
    mam = h+i*b
    day = n-i
    if mam-e*day > 0:
        ret=min(ret,i*a)
        continue
    j = ceil((-mam+day*e)/(d+e))
    if j == (-mam+day*e)//(d+e): j+=1
    ret = min(ret,i*a+j*c)
print(ret)
