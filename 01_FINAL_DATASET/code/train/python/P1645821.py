A = [list(map(int, input().split())) for _ in range(4)]

for i in range(4):
    for j in range(4):
        for p, q, in zip((1, 0), (0, 1)):
            x = i + p
            y = j + q
            if x >= 4 or y >= 4:
                continue
            if A[i][j] == A[x][y]:
                print('CONTINUE')
                exit()

print('GAMEOVER')
