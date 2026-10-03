import sys

def solve():
    H, W = map(int, input().split())
    S = [[1 if j == '#' else 0 for j in input()] for i in range(H)]

    T = [[1] * W for i in range(H)]
    U = [[0] * W for i in range(H)]

    gyakushuku(H, W, S, T)

    shukuyaku(H, W, T, U)

    for i in range(H):
        if S[i] != U[i]:
            print('impossible')
            return

    print('possible')
    for i in range(H):
        print(''.join(['#' if t else '.' for t in T[i]]))


def gyakushuku(H, W, S, T):
    dx = [1, 0, -1, 0, 1, 1, -1, -1, 0]
    dy = [0, 1, 0, -1, 1, -1, 1, -1, 0]

    for y in range(H):
        for x in range(W):
            if S[y][x] == 0:
                for i in range(len(dx)):
                    if 0 <= x + dx[i] < W and 0 <= y + dy[i] < H:
                        T[y + dy[i]][x + dx[i]] = 0

def shukuyaku(H, W, T, U):
    dx = [1, 0, -1, 0, 1, 1, -1, -1, 0]
    dy = [0, 1, 0, -1, 1, -1, 1, -1, 0]

    for y in range(H):
        for x in range(W):
            if T[y][x] == 1:
                for i in range(len(dx)):
                    if 0 <= x + dx[i] < W and 0 <= y + dy[i] < H:
                        U[y + dy[i]][x + dx[i]] = 1

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()