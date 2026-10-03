import sys
from fractions import gcd

def lcm(a, b):
    return a * b // gcd(a, b)

def solve():
    a = int(input())
    b = int(input())
    n = int(input())

    L = lcm(a, b)
    ans = L

    while 1:
        if ans >= n:
            print(ans)
            return

        ans += L



def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()