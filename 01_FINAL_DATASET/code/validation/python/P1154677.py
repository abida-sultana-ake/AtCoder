import sys

def solve():
    n = int(input())

    if n % 2:
        ans = n + 1
    else:
        ans = n - 1
        
    print(ans)

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()