def xy4(x, y):
    d = [0, 1, 0, -1, 0]
    return ((x + d[i], y + d[i + 1])
             for i in range(4))

def is_one_land(board):
    N = len(board)
    M = len(board[0])
    done = [[0]*M for _ in range(N)]
    stack = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == LAND:
                done[i][j] = True
                stack.append((i, j))
                break
        else:
            continue
        break

    while stack:
        i, j = stack.pop()
        for ni, nj in xy4(i, j):
            if (0 <= ni < N and 0 <= nj < M and
                board[ni][nj] == LAND and not done[ni][nj]):
                done[ni][nj] = True
                stack.append((ni, nj))

    for i in range(N):
        for j in range(M):
            if not done[i][j] and board[i][j] == LAND:
                return False
    return True

board = [list(input()) for _ in range(10)]
LAND = 'o'
SEA = 'x'

for i in range(10):
    for j in range(10):
        if board[i][j] == SEA:
            board[i][j] = LAND
            if is_one_land(board):
                print('YES')
                break
            board[i][j] = SEA
    else:
        continue
    break
else:
    print('NO')
