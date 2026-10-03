from collections import defaultdict
from itertools import product


memo = {}
def dfs(i, g):
    if i in memo:
        return memo[i]
    
    l = [dfs(b, g) for b in g[i]]
    if len(l) == 0:
        memo[i] = 1
    else:
        memo[i] = max(l) + min(l) + 1

    return memo[i]


def main():
    N = int(input())
    g = defaultdict(list)
    for i in range(N - 1):
        g[int(input())].append(i + 2)
    print(dfs(1, g))


if __name__ == '__main__':
    main()
