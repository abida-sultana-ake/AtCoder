def lower_bound(arr,v):
    l = 0
    r = len(arr)
    m = (l+r)//2
    while r-l>1:
        if arr[m] >= v:
            r = m
        else:
            l = m
        m = (l+r)//2

    return m

N = int(input())
w = [0] * N
h = [0] * N
for i in range(N):
    (w[i],h[i]) = map(int,input().split())

temp = ( [ (w[i],-h[i]) for i in range(N) ] )
temp.sort()
for i in range(N):
    w[i] = temp[i][0]
    h[i] = temp[i][1]

pre = -1
arr = [ -h[i] for i in range(len(h)) ]

#LIS
INF = 100000000
LIS = [-1] + [INF] * (N+2)
arr = [-1] + arr
ans = 1

for i in range(1,len(arr)):
        p = lower_bound(LIS,arr[i])
        LIS[p+1] = arr[i]

LIS = list(filter( lambda x: x<INF , LIS))
ans = len( LIS ) - 1

print (ans)

