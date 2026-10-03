import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N = int(input())
    ans = 100 * (N//10)
    if N % 10 > 6:
        ans += 100
    else:
        ans += 15 * (N % 10)

    print(ans)

if __name__ == '__main__':
    solve()