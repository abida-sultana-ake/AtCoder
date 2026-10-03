import sys
from math import sqrt

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N = int(input())
    points = [tuple(map(int, input().split())) for i in range(N)]
    ans = 0

    for i in range(N):
        for j in range(i+1, N):
            ans = max(ans, dis(points[i], points[j]))

    print(ans)

def dis(p1, p2):
    return sqrt((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2)
    
if __name__ == '__main__':
    solve()