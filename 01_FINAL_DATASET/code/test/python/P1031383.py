n = int(input())
t = [int(x) for x in input().split()]
m = int(input())
for i in range(m):
    p = [int(x) for x in input().split()]
    ans = sum(t)-t[p[0]-1]+p[1]
    print(ans)
