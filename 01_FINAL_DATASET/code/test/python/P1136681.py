import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N = int(input())
    ans = 'Blue' if N % 2 == 0 else 'Red'
    print(ans)

if __name__ == '__main__':
    solve()