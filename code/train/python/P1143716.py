import sys

def solve():
    x = int(input())
    ans = 0

    for i in range(1, x + 1):
        if i**4 == x:
            ans = i
            break

    print(ans)


def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()