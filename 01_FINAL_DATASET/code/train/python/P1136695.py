import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    D = [int(i) for i in input().split()]
    J = [int(i) for i in input().split()]
    ans = 0

    for d, j in zip(D, J):
        ans += max(d, j)

    print(ans)

if __name__ == '__main__':
    solve()