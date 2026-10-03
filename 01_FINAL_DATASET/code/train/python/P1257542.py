A = [[0] * 3 for i in range(3)]  # 盤面(0:null, 1:dai, -1,ko)
B = [list(map(int, input().split())) for _ in range(2)]
C = [list(map(int, input().split())) for _ in range(3)]


def get_key():
    return tuple(tuple(A[_]) for _ in range(3))


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
    if position == 9:
        return score()

    if stat and stat in memo.keys():
        return memo[stat]

    res = -1e10
    sign = -1 if position % 2 else 1

    for i in range(3):
        for j in range(3):
            if not A[i][j]:
                A[i][j] = sign
                res = max(res, sign * min_max(get_key(), position + 1))
                A[i][j] = 0

    memo[get_key()] = sign * res
    return sign * res


spam = min_max(None, 0)
print(spam)
print(SUM_SCORE - spam)
