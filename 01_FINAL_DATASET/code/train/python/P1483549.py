N, M = map(int, input().split())
graph = [list() for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)
    
for g1 in graph[0]:
    if N-1 in graph[g1]:
        print("POSSIBLE")
        break
        
else:
    print("IMPOSSIBLE")