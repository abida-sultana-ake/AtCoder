def _D(R, C, X, Y, D, L):
    M = 10**9 + 7
    XY_pattern = (R - X + 1) * (C - Y + 1)  # 壁で仕切られた区間の置き方

    # フェルマーの小定理を用いてコンビネーションを効率よく計算
    n = X * Y
    factrial = [1] * (n + 2)
    for k in range(1, n + 2):
        factrial[k] = (factrial[k - 1] * k) % M

    fact_inv = [1] * (n + 2)
    fact_inv[n + 1] = pow(factrial[n + 1], M - 2, M)
    for k in range(n, -1, -1):
        fact_inv[k] = (fact_inv[k + 1] * (k + 1)) % M

    def nCr(n, r, M):
        if n < 0 or r < 0 or n < r:
            return 0
        else:
            return (factrial[n] * fact_inv[r] * fact_inv[n - r]) % M

    if X * Y == D + L:
        # デスクの置き方とラックの置き方は同一視できる
        desk_pattern = nCr(X * Y, D, M)  # == nCr(X*Y,L,M)
    else:
        # X*Y=D+Lでない場合、デスクもラックも置かれていない行または列が
        # できる可能性があるが、そのような置き方は数えてはいけない
        # 今回の場合は、XY領域の最上列/最左列/最下列/最右列を使っている/いない
        # のパターンについて包除原理を用いる

        N = D + L
        desk_pattern = \
            (nCr(X * Y, N, M)  # 使っていない列が0列
             - 2 * (nCr(X * (Y - 1), N, M) + nCr((X - 1) * Y, N, M))  # 1列
             + (nCr((X - 2) * Y, N, M) + nCr(X * (Y - 2), N, M)
                + 4 * nCr((X - 1) * (Y - 1), N, M))  # 2列
             - 2 * (nCr((X - 2) * (Y - 1), N, M) + \
                    nCr((X - 1) * (Y - 2), N, M))  # 3列
                + nCr((X - 2) * (Y - 2), N, M)) * nCr(N, D, M) % M  # 4列
    return (XY_pattern * desk_pattern) % M

R,C = [int(i) for i in input().split()]
X,Y = [int(i) for i in input().split()]
D,L = [int(i) for i in input().split()]
print(_D(R,C,X,Y,D,L))