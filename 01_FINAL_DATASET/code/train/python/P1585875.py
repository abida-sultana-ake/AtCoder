from itertools import permutations
def read(): return list(map(int, input().split()))


INF = 114514810


def wf(d):
    N = len(d[0])
    for k in range(N):
        for i in range(N):
            for j in range(N):
                if d[i][j] > d[i][k] + d[k][j]:
                    d[i][j] = d[i][k] + d[k][j]
    return d


def calc_dist(p, d):
    dist = 0
    for i in range(len(p) - 1):
        if d[p[i]][p[i + 1]] >= INF:
            return INF
        dist += d[p[i]][p[i + 1]]
    return dist


def main():
    N, M, R = read()
    r = map(lambda x: x - 1, sorted(read()))
    d = [[INF for i in range(N)] for j in range(N)]

    for i in range(M):
        a, b, c, = read()
        a -= 1
        b -= 1
        d[a][b] = d[b][a] = c

    d = wf(d)

    min_dist = INF
    for p in list(permutations(r)):
        min_dist = min(min_dist, calc_dist(p, d))

    print(min_dist)


if __name__ == '__main__':
    main()