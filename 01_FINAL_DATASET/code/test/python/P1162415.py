import sys
from fractions import gcd

def lcm(a, b):
    return a * b // gcd(a, b)

def solve():
    s = input()
    k = int(input())
    ss = set()

    if len(s) < k:
        print(0)
        return

    for i in range(len(s) - k + 1):
        ss.add(s[i:i + k])

    # print(ss)

    ans = len(ss)
    print(ans)


def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()