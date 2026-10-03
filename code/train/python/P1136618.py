import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    Y = int(input())
    ans = 'YES' if is_uruu(Y) else 'NO'
    print(ans)

def is_uruu(y):
    if y % 400 == 0:
        return True
    elif y % 100 == 0:
        return False
    elif y % 4 == 0:
        return True
    else:
        return False

if __name__ == '__main__':
    solve()