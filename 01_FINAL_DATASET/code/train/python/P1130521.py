import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    s = input()
    n = len(s) - 2
    if s[0] == s[-1]:
        n += 1

    if n % 2:
        ans = 'First'
    else:
        ans = 'Second'

    print(ans)


if __name__ == '__main__':
    solve()