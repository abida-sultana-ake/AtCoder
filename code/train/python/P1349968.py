W, H = list(map(int, input().split()))
N = int(input())
M = [list(map(int, input().split())) for _ in range(N)]

memo = dict()


def solve(i, j, k, l):  # x:i->j y:k->l
    if i > j or k > l:
        return 0
    if (i, j, k, l) in memo:
        return memo[(i, j, k, l)]

    res = 0
    for x, y in [m for m in M if i <= m[0] <= j and k <= m[1] <= l]:
        # 回収
        tmp = ((j - i) + 1 + (l - k) + 1) - 1

        # 領域4分割
        tmp += solve(i, x - 1, k, y - 1)
        tmp += solve(x + 1, j, k, y - 1)
        tmp += solve(i, x - 1, y + 1, l)
        tmp += solve(x + 1, j, y + 1, l)
        res = max(tmp, res)

    memo[(i, j, k, l)] = res
    return res


print(solve(1, W, 1, H))
