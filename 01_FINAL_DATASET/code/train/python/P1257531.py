A = [[0] * 3 for i in range(3)]  # 盤面(0:null, 1:dai, 2,ko)
B = [list(map(int, input().split())) for _ in range(2)]
C = [list(map(int, input().split())) for _ in range(3)]


def A_to_k():
    return ''.join([s for s in [''.join(map(str, A[i])) for i in range(3)]])

memo = dict()

SUM_SCORE = 0
for i in range(3):
    for j in range(2):
        SUM_SCORE += B[j][i] + C[i][j]


def score():
    res = 0
    for i in range(3):
        for j in range(2):
            if A[j][i] != A[j + 1][i]:
                res += B[j][i]
            if A[i][j] != A[i][j + 1]:
                res += C[i][j]
    return SUM_SCORE - res


def min_max(stat, position):
    global A
    if position == 9:
        return score()

    if stat and stat in memo.keys():
        return memo[stat]

    # turn = position % 2
    if position % 2 == 0:  # dai
        res = -1e10
        for i in range(3):
            for j in range(3):
                if not A[i][j]:
                    A[i][j] = 1

                    res = max(res, min_max(A_to_k(), position + 1))
                    A[i][j] = 0

    else:  # ko
        res = 1e10
        for i in range(3):
            for j in range(3):
                if not A[i][j]:
                    A[i][j] = 2
                    res = min(res, min_max(A_to_k(), position + 1))
                    A[i][j] = 0

    memo[A_to_k()] = res
    return res


spam = min_max(None, 0)
print(spam)
print(SUM_SCORE - spam)
