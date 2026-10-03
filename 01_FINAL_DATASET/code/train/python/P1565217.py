c = [[w for w in input().split()] for i in range(4)]
for i in range(3, -1, -1):
    for j in range(3, -1, -1):
        if j == 0:
            print(c[i][j])
        else:
            print(c[i][j], end=" ")
            