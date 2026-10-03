N, M = map(int, input().split())
adj_matrix = [[0]* N for _ in range(N)]

for i in range(M):
    a, b = map(int, input().split())
    adj_matrix[a-1][b-1] = 1
    adj_matrix[b-1][a-1] = 1

def dfs(v, used):
    if not False in used:
        return 1
    
    ans = 0
    for i in range(N):
        if not adj_matrix[v][i]:
            continue
        if used[i]:
            continue
        
        used[i] = True
        ans += dfs(i, used)
        used[i] = False
    
    return ans

used = [False] * N
used[0] = True

print(dfs(0, used))