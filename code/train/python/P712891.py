import math

N,Q = map(int, input().split())
cones = [list(map(int, input().split())) for _ in range(N)]
# print(cones)

for _ in range(Q):
    a,b = map(int, input().split())
    # print('query', a, b)
    sum = 0
    for (x,r,h) in cones:
        # print((x,r,h))
        if b <= x:
            # print('skipped 1')
            continue
        if x+h <= a:
            # print('skipped 2')
            continue
        vol = math.pi * r**2 * h / 3
        if x < a:
            # print('mod by a')
            vol = (x+h-a)**3 / h**3 * vol
        btm = max(x,a)
        if b < x+h:
            # print('mod by b')
            vol -= (x+h-b)**3 / (x+h-btm)**3 * vol
        sum += vol
    print(sum)
