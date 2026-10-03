n,a,b = map(int,input().split())
ar = [int(x) for x in input().split()]
f = 0
for i in range(n-1):
    t = ar[i+1]-ar[i]
    if t*a > b:
        f += b
    else:
        f += t*a

print(f)