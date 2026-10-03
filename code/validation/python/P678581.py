n, q = (int(x) for x in input().split())
each = [0] * (n + 1)
for qi in range(q):
    l, r = (int(x) for x in input().split())
    each[l - 1] ^= 1
    each[r] ^= 1
each.pop()
for ni in range(1, n):
    each[ni] ^= each[ni - 1]
print(*each, sep='')