import sys

def solve():
    S = input().split('+')
    ans = 0

    debug(S, locals())

    for kou in S:
        if '0' not in kou:
            ans += 1

    print(ans)



def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()