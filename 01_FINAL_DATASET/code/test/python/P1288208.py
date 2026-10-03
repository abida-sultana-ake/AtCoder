n = int(input())
ta = [list(map(int, input().split())) for x in range(n)]


def fit(a, b):
    for i in range(1000, 1, -1):
        if a%i == b%i == 0:
            return a // i, b // i
    return a, b


def to(a, b, limit):
    cnt = (limit[0] + a - 1) // a
    ac = a * cnt
    bc = b * cnt
    if limit[0] <= ac and limit[1] <= bc:
        return ac, bc

    cnt = (limit[1] + b - 1) // b
    ac = a * cnt
    bc = b * cnt
    if limit[0] <= ac and limit[1] <= bc:
        return ac, bc


now = [1, 1]
for t, a in ta:
    t, a = fit(t, a)
    now = to(t, a, now)
print(sum(now))
