n,m = map(int,input().split())
arr = [list(map(int,input().split())) for i in range(m)]
ans = []
for i in arr:
    ans.extend(i)
for i in range(1,n + 1):
    print(ans.count(i))