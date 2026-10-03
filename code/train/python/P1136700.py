import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    n = int(input())
    ans = ((9/5)*n) + 32
    print(ans)

if __name__ == '__main__':
    solve()