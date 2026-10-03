import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    A, B = map(int, input().split())

    if abs(A) > abs(B):
        ans = 'Bug'
    elif abs(B) > abs(A):
        ans = 'Ant'
    else:
        ans = 'Draw'

    print(ans)

if __name__ == '__main__':
    solve()