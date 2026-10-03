M = int(1e9 + 7)

N = int(input())
A = [[] for _ in range(N)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    A[a].append(b)
    A[b].append(a)

visited = set()
def dfs(i):
    if i in visited:
        return 0, 1
    visited.add(i)

    n_blacks = 1
    n_whites = 1
    for j in A[i]:
        b, w = dfs(j)
        n_blacks *= w
        n_blacks %= M

        n_whites *= (b + w) % M
        n_whites %= M

    return n_blacks, n_whites

b, w = dfs(0)
print((b + w) % M)
