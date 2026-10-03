#他人のプログラム参考にした
#Nが小さいのと入力ｘ＜ｙを利用
#全組み合わせを再帰的にうまく試す
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
        
N, M = map(int, input().split())
xy = [[0 for _ in range(N)] for _ in range(N)]
v = []
ans = 0
 
for _ in range(M):
    x, y = map(int, input().split())
    xy[x-1][y-1] = 1
    
dfs(v)
 
print(ans)