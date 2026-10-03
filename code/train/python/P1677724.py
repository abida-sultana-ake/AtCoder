n = int(input())
a,b = map(int,input().split())
m = int(input())
table = [[0]*n for i in range(n)]
for i in range(m):
    x,y = map(int,input().split())
    table[x-1][y-1] = table[y-1][x-1] = 1
move = [[110,0] for i in range(n)]
move[a-1] = [0,1]
visited = [False for i in range(n)]
q = [a-1]

while len(q)>0:
    t = q.pop(0)
    te = move[t][0]
    if not visited[t]:
        visited[t] = True
        conn = [i for i in range(n) if table[i][t] == 1]
        q.extend(conn)
        for i in conn:
            if move[i][0] > te+1:
                move[i] = [te+1,move[t][1]]
            elif move[i][0] == te + 1:
                move[i][1] += move[t][1]

print(move[b-1][1]%1000000007)
