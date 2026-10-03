MOD = 10 ** 9 + 7
N = int(input())
edges = [[] for _ in range(N)]
for _ in range(N-1):
    a, b = list(map(int, input().split()))
    edges[a-1].append(b-1)
    edges[b-1].append(a-1)
q = [0]
top = 0
visited = [False] * N
visited[0] = True
while top < len(q):
    node = q[top]
    top += 1
    for n in edges[node]:
        if visited[n]:
            continue
        visited[n] = True
        q.append(n)
white = [1] * N
both = [1] * N  # 変数名が思いつかない
for node in reversed(q):    
    both[node] = (both[node] + white[node]) % MOD
    for par in edges[node]:
        white[par] = (white[par] * both[node]) % MOD
        both[par] = (both[par] * white[node]) % MOD
print(both[0])
    
