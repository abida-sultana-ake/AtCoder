from collections import defaultdict
MOD = 10 ** 9 + 7


def dfs(x, parent, children, f, g):

    for child in children[x]:
        if child == parent:
            continue
        dfs(child, x, children, f, g)

    for child in children[x]:
        g[x] = (g[x] * f[child]) % MOD

    for child in children[x]:
        f[x] = (f[x] * g[child]) % MOD
    f[x] = (f[x] + g[x]) % MOD


def main():
    N = int(input())
    children = defaultdict(list)

    for _ in range(N - 1):
        a, b = map(lambda x: int(x) - 1, input().split())
        children[a].append(b)
        children[b].append(a)

    f, g = [1] * N, [1] * N
    dfs(0, -1, children, f, g)
    print(f[0])


if __name__ == "__main__":
    main()
