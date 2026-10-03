from sys import stdin

mod = 10**9 + 7

def solve():
    N = int(stdin.readline())
    Adj = [[] for i in range(N)]

    for i in range(N - 1):
        a, b = map(int, stdin.readline().split())
        a, b = a - 1, b - 1
        Adj[a].append(b)
        Adj[b].append(a)

    uni, siro = dfs(N, Adj, 0, 0)

    ans = uni

    print(ans)

def dfs(N, Adj, v, p):
    siro = 1
    kuro = 1

    for u in Adj[v]:
        if u == p:
            continue

        unic, siroc = dfs(N, Adj, u, v)
        siro = (siro * unic) % mod
        kuro = (kuro * siroc) % mod

    uni = (kuro + siro) % mod

    return uni, siro

if __name__ == '__main__':
    solve()