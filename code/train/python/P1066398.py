n,a,b = map(int,input().split())
x = list(map(int,input().split()))
count = 0
for i in range(n-1):
    r = x[i+1] - x[i]
    if a*r <= b:
        count += a*r
    else:
        count += b
print(count)