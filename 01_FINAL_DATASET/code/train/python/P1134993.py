from itertools import product as prod

n = int(input())
dss = []
for _ in range(n):
    ds = list(map(int, input().split()))
    dss.append(ds)

square_memo = [[-1] * n for _ in range(n)]

# (0, 0) と (x, y) が張る長方形のおいしさの総和
def square_from_origin(x, y):
    if x < 0 or y < 0:
        return 0
    if square_memo[x][y] == -1:
        s = 0
        s += square_from_origin(x-1, y)
        s += square_from_origin(x, y-1)
        s -= square_from_origin(x-1, y-1)
        s += dss[x][y]
        square_memo[x][y] = s
    return square_memo[x][y]

# (x, y) と (w, h) が張る長方形のおいしさの総和
def square(x, y, w, h):
    s = 0
    s += square_from_origin(w, h)
    s -= square_from_origin(x-1, h)
    s -= square_from_origin(w, y-1)
    s += square_from_origin(x-1, y-1)
    return s

dss_maxes = [0] * n**2
for w, h in prod(range(n), repeat=2):
    x_max = n - w
    y_max = n - h
    idx = (w + 1) * (h + 1) - 1
    for x, y in prod(range(x_max), range(y_max)):
        tmp_s = square(x, y, x + w, y + h)
        if tmp_s > dss_maxes[idx]:
            dss_maxes[idx] = tmp_s

tmp_max = 0
for i in range(n**2):
    if dss_maxes[i] > tmp_max:
        tmp_max = dss_maxes[i]
    else:
        dss_maxes[i] = tmp_max

q = int(input())
for _ in range(q):
    p = int(input())
    print(dss_maxes[p-1])
