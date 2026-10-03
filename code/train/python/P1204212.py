from operator import itemgetter
N = int(input())
a, b = list(map(int, input().split()))
paths = [[0] * (N + 1) for _ in range(N + 1)]
min_cnt = [[0] * 2 for _ in range(N + 1)] # node_cnt, cnt
for i in range(N + 1):
    min_cnt[i][0] = 1e10

min_cnt[a][0] = 0
min_cnt[a][1] = 1

for i in range(int(input())):
    x, y = list(map(int, input().split()))
    paths[x][y] = 1
    paths[y][x] = 1

cnt = 0

pool = [(a, 0)]
while pool:
    p = pool.pop(0)
    if min_cnt[p[0]][0] < p[1]: continue

    tmp_cnt = p[1] + 1
    for i in [i for i in range(1, N + 1) if paths[p[0]][i]]:
        if min_cnt[i][0] > tmp_cnt:
            min_cnt[i][0] = tmp_cnt
            min_cnt[i][1] = min_cnt[p[0]][1]
            pool.append((i, tmp_cnt))
        elif min_cnt[i][0] == tmp_cnt:
            min_cnt[i][1] += min_cnt[p[0]][1] % 1000000007

    pool.sort(key=itemgetter(1))

print(min_cnt[b][1] % 1000000007)
