n,ma,mb = list(map(int,input().split()))
G=[]
for i in range(n):
    G.append(list(map(int,input().split())))

DP = [[10000 for _ in range(500)] for _ in range(500)]
DP[0][0]=0
for i in range(n):
    for j in reversed(range(400)):
        for k in reversed(range(400)):
            if DP[j][k]==10000:continue
            DP[j+G[i][0]][k+G[i][1]] = min(DP[j][k]+G[i][2],DP[j+G[i][0]][k+G[i][1]])

ans=10000
for i in range(1,min(400//ma,400//mb)+1):
    ans=min(ans,DP[ma*i][mb*i])

if ans==10000:
    print(-1)
else:
    print(ans)
    
