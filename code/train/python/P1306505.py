import collections
H,W = map(int,input().split())
Map = []
start,goal = (0,0),(0,0)
for i in range(H):
    s = list(input())
    if "s" in s:
        start = (i,s.index("s"))
    if "g" in s:
        goal = (i,s.index("g"))
    Map.append(s)
searched = [[3 for b in range(W)] for c in range(H)]
que = collections.deque()
que.append((start[0], start[1], 0))


flag = False
while len(que) > 0:
    x,y,n = que.popleft()
    tmp = False
    if searched[x][y] <= n:
        continue

    searched[x][y] = n

    if x > 0:
        c = Map[x-1][y]
        if c == "g":
            flag = True
            break
        elif c == "#":
            if n < 2:
                que.append((x-1,y,n+1))
        else:
            que.append((x-1,y,n))
    if x < H-1:
        c = Map[x+1][y]
        if c == "g":
            flag = True
            break
        elif c == "#":
            if n < 2:
                que.append((x+1,y,n+1))
        else:
            que.append((x+1,y,n))
    if y > 0:
        c = Map[x][y-1]
        if c == "g":
            flag = True
            break
        elif c == "#":
            if n < 2:
                que.append((x,y-1,n+1))
        else:
            que.append((x,y-1,n))
    if y < W-1:
        c = Map[x][y+1]
        if c == "g":
            flag = True
            break
        elif c == "#":
            if n < 2:
                que.append((x,y+1,n+1))
        else:
            que.append((x,y+1,n))

if flag:
    print("YES")
else:
    print("NO")
