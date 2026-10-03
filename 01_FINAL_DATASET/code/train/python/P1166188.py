
dx = (1, 0, -1, 0,)
dy = (0, 1, 0, -1,)

A = [[int(j) for j in input().split()] for i in range(4)]

for i in range(4):
    for j in range(4):
        for k in range(len(dx)):
            if 0 <= i + dy[k] < 4 and 0 <= j + dx[k] < 4:
                if A[i][j] == A[i + dy[k]][j + dx[k]]:
                    print('CONTINUE')
                    quit()

print('GAMEOVER')