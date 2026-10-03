# ある値n以下の非負整数の個数


denny = (4, 9)


def calc(_A):

    A = str(_A)
    dp = [[[0] * 2 for i in range(2)] for j in range(len(A) + 1)]
    dp[0][0][0] = 1

    for i in range(len(A)):
        for j in range(2):
            # j=0 : 現在の桁まで数字が同じ
            # j=1 : すでに小さい数値とわかっている

            # limには次の桁の数字の最大値を代入する
            lim = 9 if j == 1 else (ord(A[i]) - ord('0'))
            for v in range(lim + 1):
                for k in range(2):
                    # k=0: 4, 9 を含まない
                    # k=1: すでに4, 9 を含む

                    dp[i + 1][v < lim or j == 1][v in denny or k == 1] += dp[i][j][k]
        # print(dp)

    return dp[len(A)][1][1] + dp[len(A)][0][1]


if __name__ == '__main__':
    a, b = list(map(int, input().split()))
    v = calc(b) - calc(a - 1)
    print(v)
