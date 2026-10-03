import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    y = int(input())
    m = int(input())
    d = int(input())

    ans = calc(2014, 5, 17) - calc(y, m, d)

    print(ans)

def calc(y, m, d):
    if m == 1 or m == 2:
        m += 12
        y -= 1

    res = 365*y + y//4 - y//100 + y//400 + 306*(m+1)//10 + d - 429

    return res

if __name__ == '__main__':
    solve()