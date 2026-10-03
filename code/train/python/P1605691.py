N, M = list(map(int, input().split()))
xy = [[0 for _ in range(N)] for _ in range(N)] #隣接行列てきなの
v = []
ans = 0

def dfs(v, k=0):
    global ans
    if (k==N):
        for i in range(len(v)):
            for j in range(i+1, len(v)):
                if (xy[v[i]][v[j]] == 0):
                    return
        ans = max(ans, len(v))
    else:
        dfs(v, k+1)
        v.append(k)
        dfs(v, k+1)
        v.pop()
for _ in range(M):
    x, y = list(map(int, input().split()))
    xy[x-1][y-1] = 1
    
dfs(v)
 
print(ans)