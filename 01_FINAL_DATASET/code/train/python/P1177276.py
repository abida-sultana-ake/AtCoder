import sys

def solve():
    A, B, C, D = map(int, input().split())
    taka= B / A
    ao = D / C

    if taka > ao:
        ans = 'TAKAHASHI'
    elif ao > taka:
        ans = 'AOKI'
    else:
        ans = 'DRAW'

    print(ans)

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()