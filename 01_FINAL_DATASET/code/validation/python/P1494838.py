#dfs典型、実装できない（頭が悪くて辛い）

N, K = tuple(map(int, input().split()))
T = [list(map(int, input().split())) for i in range(N)]

def dfs(i, s):
    if i == N:
        return s == 0 
    for j in range(K):
        if dfs(i+1,s^T[i][j]):
            return True
    return False

if dfs(0,0):
    print("Found")
else:
    print("Nothing")