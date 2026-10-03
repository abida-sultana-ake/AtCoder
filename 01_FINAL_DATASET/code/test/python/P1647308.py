def C_coin(N, C):
    # i番目の要素は、Cのi番目の要素に対して(注目した要素自身を除いた)約数がC内に何個あるかを意味する
    divisor = [None for i in range(len(C))]

    for idx, c in enumerate(C):
        tmp = 0
        for i in range(len(C)):
            if i == idx:
                pass
            else:
                if c % C[i] == 0:
                    tmp += 1
        divisor[idx] = tmp
    # ex.C=>[2,4,8],divisor=>[0,1,2]
    # 2の約数は0個、4の約数は1個、8の約数は2個あると解釈

    # 確率計算
    ans = 0
    for d in divisor:
        if d % 2 == 0:
            ans += (d + 2) / (2 * (d + 1))
        else:
            ans += 0.5
    return ans
  
N = int(input())
C = [int(input()) for _ in range(N)]
print(C_coin(N, C))