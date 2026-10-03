import heapq
def factorial(n):
    res = 1
    while n>1:
        res *= n
        n -= 1
    return res

n,m = map(int, input().split())
req = [0 for i in range(n)]

for i in range(m):
    x,y = map(int, input().split())
    req[y-1] += 2**(x-1)
visited = [False for i in range(2**n)]
dp = [0 for i in range(2**n)]
dp[0] = 1
h = []
for i in range(n):
    if req[i] == 0:
        heapq.heappush(h,2**i)
        dp[2**i] = 1
while h:
    q = heapq.heappop(h)
    if(visited[q]):
        continue
    visited[q] = True
    for i in range(n):
        if (q & req[i]) == req[i] and (q & 2**i) == 0:
            dp[q+2**i] += dp[q]
            heapq.heappush(h,q+2**i)
print(dp[2**n-1])