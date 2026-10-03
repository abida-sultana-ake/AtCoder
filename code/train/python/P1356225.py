
inf = 10 ** 20


def solve(n, m, weights):
    score = [-inf] * n
    score[0] = 0
    pred = [-1] * n

    for step in range(n):
        for edge, c in weights.items():
            a, b = edge
            if score[b] < score[a] + c:
                score[b] = score[a] + c
                pred[b] = a

    b = n - 1
    while b != 0:
        a = pred[b]
        c = weights[(a, b)]
        if score[b] < score[a] + c:
            return 'inf'
        b = a
    return score[n-1]


def solve2(n, m, weights):
    score = [-inf] * n
    score[0] = 0
    pred = [-1] * n

    for step in range(n):
        for edge, c in weights.items():
            a, b = edge
            if score[b] < score[a] + c:
                score[b] = score[a] + c
                pred[b] = a

    res = score[n-1]

    for step in range(n):
        for edge, c in weights.items():
            a, b = edge
            if score[b] < score[a] + c:
                score[b] = score[a] + c
                pred[b] = a

    if res < score[n-1]:
        return 'inf'
    return res


def main():
    n, m = map(int, input().split())
    weights = {}
    for _ in range(m):
        a, b, c = map(int, input().split())
        a -= 1
        b -= 1
        weights[(a, b)] = c

    res = solve2(n, m, weights)
    print(res)

if __name__ == '__main__':
    main()
