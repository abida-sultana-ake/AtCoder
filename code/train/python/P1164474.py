from sys import stdin, stdout, stderr

def solve():
    N = int(input())
    A = [int(i) for i in input().split()]

    ans = (-100) * 50

    for i in range(N):
        ans = max(ans, calc_score(N, A, i))

    assert ans > (-100) * 50

    print(ans)

def calc_score(N, A, m):
    res = (-100) * 50
    ao_max = (-100) * 50

    for j in range(N):
        if j == m:
            continue

        taka, ao = 0, 0

        if j < m:
            for k in range(j, m + 1):
                if (k - j) % 2:
                    ao += A[k]
                else:
                    taka += A[k]
        else:
            for k in range(m, j + 1):
                if (k - m) % 2:
                    ao += A[k]
                else:
                    taka += A[k]

        if ao > ao_max:
            ao_max = ao
            res = taka

    assert res > (-100) * 50

    return res

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=stderr)
            return None

if __name__ == '__main__':
    solve()