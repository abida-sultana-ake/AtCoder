import sys
from fractions import gcd

def lcm(a, b):
    return a * b // gcd(a, b)

def solve():
    a = int(input())
    b = int(input())
    n = int(input())

    L = lcm(a, b)
    ans = (n + L - 1) // L * L

    print(ans)



def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()