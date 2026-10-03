def rren(): return list(map(int, input().split())) 
N, M = rren()
friends = [[0 for i in range(N)] for j in range(N)]
Ans = [set() for _ in range(N)]
for k in range(M):
    A, B = rren()
    friends[A-1][B-1] = friends[B-1][A-1] = 1

for x in range(N):
    for y in range(N):
        if friends[x][y] == 1:
            for z in range(N):
                if friends[y][z] == 1 and friends[x][z] == 0:
                    Ans[x].add(z)
            Ans[x].discard(x)
for p in range(N):
    print(len((Ans[p])))
