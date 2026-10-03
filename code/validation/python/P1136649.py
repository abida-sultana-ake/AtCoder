import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    E = [int(i) for i in input().split()]
    B = int(input())
    L = [int(i) for i in input().split()]
    cnt = 0

    for cl in L:
        for ce in E:
            if cl == ce:
                cnt += 1

    if cnt == 6:
        ans = 1
    elif cnt == 5 and B in L:
        ans = 2
    elif cnt == 5:
        ans = 3
    elif cnt == 4:
        ans = 4
    elif cnt == 3:
        ans = 5
    else:
        ans = 0

    print(ans)

if __name__ == '__main__':
    solve()