import sys
from itertools import combinations

def solve():
    N, K = map(int, input().split())
    cmb = 1 + 3 * (K - 1) + 3 * (N - K) + 6 * (K - 1) * (N - K)
    ans = cmb / (N**3)

    print('{:.12f}'.format(ans))

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()