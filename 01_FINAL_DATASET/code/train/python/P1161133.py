import sys

def solve():
    S = input()
    ans = 0
    flag = True

    for c in S:
        if c == '0':
            flag = False
        elif c == '+':
            ans += flag
            flag = True

    ans += flag

    print(ans)

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()