def calc_ans(x):
    if x < 0:
        return 0
    elif x < X:
        return x
    else:
        return X


if __name__ == '__main__':
    # 砂の合計量
    X = int(input())

    # ひっくり返す回数
    K = int(input())
    # ひっくり返す秒数
    r = list(map(int, input().split()))
    # クエリの個数
    Q = int(input())

    # r の制御のための変数
    j = 0
    sign = -1
    s = 0
    e = X
    y = 0
    sand_quantity = [r[0]]
    for i in range(1, K):
        sand_quantity.append(r[i] - r[i - 1])

    chasm_time = 0
    for i in range(Q):
        # t:時刻 a:初期に A に入っている砂の量
        t, a = list(map(int, input().split()))
        while j < K and r[j] < t:
            y += sign * sand_quantity[j]
            # sについて更新
            if y < 0:
                s += -y
                if e < s:
                    s = e
                y = 0
            # eについて更新
            if X < y + e - s:
                tmp_diff = (y + e - s) - X
                e -= tmp_diff
                if e < s:
                    e = s
            if X < y:
                y = X

            chasm_time = r[j]
            j += 1
            sign *= -1

        tmp_time = t - chasm_time

        if a < s:
            ret = y
        elif a < e:
            ret = y + a - s
        else:
            ret = y + e - s

        ret += tmp_time * sign

        print(calc_ans(ret))
        # print("s:" + str(s) + " e:" + str(e) + " y:" + str(y) + " a:" + str(a) + " ret:" + str(ret))
