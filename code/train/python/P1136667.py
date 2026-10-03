import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N, A, B = map(int, input().split())
    ans = max(N-5, 0)*A + min(5, N)*B
    print(ans)

if __name__ == '__main__':
    solve()