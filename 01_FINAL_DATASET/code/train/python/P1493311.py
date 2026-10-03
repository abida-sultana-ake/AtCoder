from collections import defaultdict


# 8近傍（右, 下, 左, 上，右上, 右下, 左下, 左上）
dy = [0, -1, 0, 1, 1, -1, -1, 1]
dx = [1, 0, -1, 0, 1, 1, -1, -1]
def compress(l):
    ans = [["."] * len(l[0]) for _ in range(len(l))]
    for y in range(len(l)):
        for x in range(len(l[0])):
            if l[y][x] == "#":
                for ny, nx in [(y + dy[i], x + dx[i]) for i in range(8)]:
                    ans[y][x] = "#"
                    if 0 <= ny < len(l) and 0 <= nx < len(l[0]):
                        ans[ny][nx] = "#"
    return ans


def uncompress(l):
    ans = [["#"] * len(l[0]) for _ in range(len(l))]
    for y in range(len(l)):
        for x in range(len(l[0])):
            if l[y][x] == ".":
                for ny, nx in [(y + dy[i], x + dx[i]) for i in range(8)]:
                    ans[y][x] = "."
                    if 0 <= ny < len(l) and 0 <= nx < len(l[0]):
                        ans[ny][nx] = "."

    return ans


def main():
    H, W = map(int, input().split())
    l = [list(input()) for _ in range(H)]

    ans = uncompress(l)
    r = compress(ans)
    if l != r:
        print("impossible")
    else:
        print("possible")
        print(*["".join(line) for line in ans], sep="\n")

if __name__ == '__main__':
    main()
