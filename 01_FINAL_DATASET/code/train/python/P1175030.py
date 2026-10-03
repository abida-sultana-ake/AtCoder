import sys
n = int(input())
a = sorted(map(int,input().split()))
ans = sys.maxsize
for i in range(202):
    x = -100 + i
    cost = 0
    for v in a:
        cost += ( x - v )**2
    ans = min(ans,cost)
print(ans)
