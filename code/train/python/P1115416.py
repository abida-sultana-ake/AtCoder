n, m = [int(i) for i in input().split()]

if m > 2 * n:
    d = m - 2 * n
    d //= 4
    n += d
    m -= 2 * d
    print(n)
else:
    print(m // 2)
