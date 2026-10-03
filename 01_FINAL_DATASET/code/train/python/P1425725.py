# D

from collections import deque

N = int(input())
G = dict()
for i in range(N):
    G[i+1] = []
    
for _ in range(N-1):
    a, b = map(int, input().split())
    G[a].append(b)
    G[b].append(a)
    
# dist form 1
dist_1 = [N]*(N+1)
dist_1[1] = 0

# BFS
que = deque([1])
while len(que) > 0:
    a = que.popleft()
    for b in G[a]:
        if dist_1[b] > dist_1[a] + 1:
            dist_1[b] = dist_1[a] + 1
            que.append(b)
            
# dist form N
dist_N = [N]*(N+1)
dist_N[N] = 0

# BFS
que = deque([N])
while len(que) > 0:
    a = que.popleft()
    for b in G[a]:
        if dist_N[b] > dist_N[a] + 1:
            dist_N[b] = dist_N[a] + 1
            que.append(b)
            

# count
count_Fennec = 0
for i in range(N):
    if dist_1[i+1] <= dist_N[i+1]:
        count_Fennec += 1

if count_Fennec > N - count_Fennec:
    print('Fennec')
else:
    print('Snuke')