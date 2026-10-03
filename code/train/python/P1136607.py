import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N = int(input())
    gpa = {'A':4, 'B':3, 'C':2, 'D':1, 'F':0}
    ans = sum(gpa[i] for i in input())/N

    print(ans)

if __name__ == '__main__':
    solve()