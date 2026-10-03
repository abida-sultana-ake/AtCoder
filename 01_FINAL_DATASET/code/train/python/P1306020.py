import collections
Map = []

for i in range(10):
    Map.append(list(input()))

flag = True
for i in range(100):
    p,q = int(i/10), i%10

    #島判定
    if Map[p][q] == "x":
        queue = collections.deque()
        searched = [[True if Map[b][a] == "x" else False for a in range(10)] for b in range(10)]
        queue.append((p,q))
        while len(queue) > 0:
            (x,y) = queue.popleft()
            searched[x][y] = True
            if x > 0:
                if not searched[x-1][y]:
                    queue.append((x-1,y))
            if x < 9:
                if not searched[x+1][y]:
                    queue.append((x+1,y))
            if y > 0:
                if not searched[x][y-1]:
                    queue.append((x,y-1))
            if y < 9:
                if not searched[x][y+1]:
                    queue.append((x,y+1))
        flag = True
        for s in searched:
            if False in s:
                flag = False
                break
        if flag:
            break
if flag:
    print("YES")
else:
    print("NO")
