import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    N, x = map(int, input().split())
    A = [int(i) for i in input().split()]
    ans = 0

    for i in range(1, N):
        tmp = max(min(A[i] + A[i-1] - x, A[i]), 0)
        A[i] -= tmp
        ans += tmp
        
        if A[i] + A[i - 1] > x:
            tmp = A[i - 1] - x
            A[i - 1] -= tmp
            ans += tmp

    print(ans)


if __name__ == '__main__':
    solve()