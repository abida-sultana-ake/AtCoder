from itertools import product

N, K = list(map(int, input().split()))
q = [list(map(int, input().split())) for _ in range(N)]


def check(l):
    v = l[0]
    if len(l) > 1:
        for lv in l[1:]:
            v ^= lv

    return v == 0


patt = list()
for pt in product(range(K), repeat=N):
    if check([q[pi][p] for pi, p in enumerate(pt)]):
        print('Found')
        exit()

print('Nothing')
