def D_ProhibitedNumber(A, B):
    def prohibit_number(n):
        # 1からnまでの間に4,9を含む数字が出てきた回数
        if n < 4:
            return 0
        # 数値nを1桁ずつリストにバラす
        a = []
        while n > 0:
            a.append(n % 10)
            n //= 10
        a.reverse()
        digit = len(a)  # 桁数

        dp = [[[0] * 2, [0] * 2] for _ in range(digit)]
        # dp[何桁目まで調べたか][調べた桁数でn未満だとわかったか][4または9を含んでいるか]
        # 第2,第3次元は、1番目をTrue,0番目をFalseとみなす
        for i in range(a[0]):
            # 最上位桁を調べる
            if i == 4 or i == 9:
                dp[0][1][1] += 1
            else:
                dp[0][1][0] += 1

        if a[0] in [4, 9]:
            dp[0][0][1] = 1
            # 最上位桁が,n未満であり,4か9を含んでいる,と解釈する
        else:
            dp[0][0][0] = 1

        for i in range(1, digit):  # nが1桁の場合、ここは通らない
            ai = a[i]
            if ai in [4, 9]:
                dp[i][0][1] = dp[i - 1][0][0] + dp[i - 1][0][1]
            else:
                dp[i][0][0] = dp[i - 1][0][0]
                dp[i][0][1] = dp[i - 1][0][1]

            for j in range(ai):
                if j == 4 or j == 9:
                    dp[i][1][1] += sum(dp[i - 1][0])
                else:
                    dp[i][1][1] += dp[i - 1][0][1]
                    dp[i][1][0] += dp[i - 1][0][0]

            for j in range(10):
                if j in [4, 9]:
                    dp[i][1][1] += sum(dp[i - 1][1])
                else:
                    dp[i][1][1] += dp[i - 1][1][1]
                    dp[i][1][0] += dp[i - 1][1][0]
        return dp[-1][0][1] + dp[-1][1][1]
    return prohibit_number(B) - prohibit_number(A - 1)
  
A,B=[int(i) for i in input().split()]
print(D_ProhibitedNumber(A, B))