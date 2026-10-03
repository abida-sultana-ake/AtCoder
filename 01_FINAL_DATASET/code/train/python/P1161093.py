import sys

def solve():
    n = set(input())

    if len(n) == 1:
        ans = 'SAME'
    else:
        ans = 'DIFFERENT'

    print(ans)

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()