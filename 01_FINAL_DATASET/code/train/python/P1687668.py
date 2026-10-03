def D_jump(N, D, X, Y):
    if X % D != 0 or Y % D != 0:
        # X,YがDの倍数でなければ、ゴールに到達しない
        return 0.0

    # 単位量を1からDに変更
    x = abs(X) // D
    y = abs(Y) // D

    def pascal_triangle(n):
        # パスカルの三角形
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for i in range(n + 1):
            dp[i][0] = dp[i][i] = 1
        for i in range(2, n + 1):
            for j in range(i):
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        return dp
    c = pascal_triangle(N)  # 組み合わせ数を求めるために使う

    ans = 0.0
    for i in range(N + 1):
        # 左右にi回、上下にj回移動する
        j = N - i
        if x > i or y > j:
            # 左右/上下に移動する距離よりもゴールが遠い
            continue
        if (i - x) & 1 or (j - y) & 1:
            # コンビネーションの引数が整数でない
            continue
        # 左/右何回動かすか * 上/下何回動かすか * 全パターンからx軸/y軸方向に何回動かすか * 上下左右を選ぶ確率は1/4,それをN回行う
        # 左/右、上/下、x軸/y軸については、それぞれのどちらを選んでも組み合わせ数は等しい
        ans += (c[i][(i + x) // 2] * c[j][(j + y) // 2] * c[N][i]) / (4**N)
    return ans
  
N,D = [int(i) for i in input().split()]
X,Y = [int(i) for i in input().split()]
print(D_jump(N, D, X, Y))