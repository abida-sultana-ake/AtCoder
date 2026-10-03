import sys

def solve():
    N, K = map(int, input().split())
    s = [int(sys.stdin.readline().rstrip()) for i in range(N)]

    if 0 in s:
        print(N)
        return

    l, r = 0, 0
    ans = 0
    v = 1

    while r < N:
        if v * s[r] <= K:
            v *= s[r]
            r += 1
            ans = max(ans, r - l)
            # print('l, r, v:', l, r, v)
        elif r == l:
            r, l = r + 1, l + 1
        else:
            v //= s[l]
            l += 1

    print(ans)

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

if __name__ == '__main__':
    solve()