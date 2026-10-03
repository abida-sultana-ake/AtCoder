from collections import defaultdict


# 8近傍（右, 下, 左, 上，右上, 右下, 左下, 左上）
dy = [0, -1, 0, 1, 1, -1, -1, 1]
dx = [1, 0, -1, 0, 1, 1, -1, -1]
def compress(l):
    ans = [[0] * len(l[0]) for _ in range(len(l))]
    for y in range(len(l)):
        for x in range(len(l[0])):
            if l[y][x] == 1:
                for a in range(8):
                    ny = y + dy[a]
                    nx = x + dx[a]
                    ans[y][x] = 1
                    if 0 <= ny < len(l) and 0 <= nx < len(l[0]):
                        ans[ny][nx] = 1
    return ans


def uncompress(l):
    ans = [[None] * len(l[0]) for _ in range(len(l))]
    for y in range(len(l)):
        for x in range(len(l[0])):
            if l[y][x] == 0:
                for a in range(8):
                    ny = y + dy[a]
                    nx = x + dx[a]
                    ans[y][x] = 0
                    if 0 <= ny < len(l) and 0 <= nx < len(l[0]):
                        ans[ny][nx] = 0

    for y in range(len(l)):
        for x in range(len(l[0])):
            if ans[y][x] is None:
                ans[y][x] = 1

    return ans


def main():
    H, W = map(int, input().split())
    l = [list(input()) for _ in range(H)]
    for y in range(H):
        for x in range(W):
            l[y][x] = 1 if l[y][x] == "#" else 0

    ans = uncompress(l)
    r = compress(ans)
    if l != r:
        print("impossible")
    else:
        print("possible")
        for y in range(H):
            for x in range(W):
                ans[y][x] = "#" if ans[y][x] == 1 else "."
        print(*["".join(line) for line in ans], sep="\n")

if __name__ == '__main__':
    main()
