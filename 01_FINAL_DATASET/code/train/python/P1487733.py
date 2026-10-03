# coding: utf-8
INF = 10 ** 20
MOD = 10 ** 9 + 7


def II(): return int(input())
def ILI(): return list(map(int, input().split()))


def read():
    H, W = ILI()
    N = II()
    a = ILI()
    return H, W, N, a


def solve(H, W, N, a):
    ans = [[None] * W for __ in range(H)] # [H][W]
    ind_a = 0
    a_count = 0
    color_a = list(range(1, N + 1))
    for h in range(H):
        if h % 2 == 0:
            for w in range(W):
                ans[h][w] = color_a[ind_a]
                a_count += 1
                if a_count == a[ind_a]:
                    ind_a += 1
                    a_count = 0
        else:
            for w in reversed(range(W)):
                ans[h][w] = color_a[ind_a]
                a_count += 1
                if a_count == a[ind_a]:
                    ind_a += 1
                    a_count = 0

    ans = [" ".join(map(str, ele)) for ele in ans]
    ans = "\n".join(ans)
    return ans


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
