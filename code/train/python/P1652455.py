n,x = map(int,(input().split()))
a = list(map(int,input().split()))
ret = 0
for i in range(n):
    if (x>>i)&1 == 1:
        ret += a[i]
print(ret)
