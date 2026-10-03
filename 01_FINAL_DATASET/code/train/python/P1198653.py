import sys

def solve():
    n = int(input())
    ans = 0

    for k in range(1, 11):
        m = max(n - (10**(k - 1) - 1), 0)

        ans += (m // 10**k) * 10**(k - 1)
        ans += min(m % 10**k, 10**(k - 1))

    print(ans)

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()