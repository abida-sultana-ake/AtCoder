import math

# D - Maximum Average Sets
# 問題URL:http://abc057.contest.atcoder.jp/tasks/abc057_d

# N:商品の数　A個以上B個以下の範囲で選ぶ
N, A, B = map(int, input().split())
# C：最大価値組み合わせ総数
C = 0

# 商品価値をリストに入れる
V = [int(value) for value in input().split()]
# 商品価値が高い順に並び替え
V.sort(reverse=True)

# 商品価値が高いものから出来るだけ少なく（＝A個）選ぶのが最も平均価値が高くなる
S = V[:A]
ave = sum(S) / A
print(ave)

Vs = V.count(min(S)) # A個選んだ中で最も低い価値を持つ商品は、もともとの商品リストの中にいくつあるか
Ss = S.count(min(S)) # A個選んだ時中で最も低い価値を持つ商品はいくつあるか

if min(S) == max(S): # もしもA個選んだ中の商品価値が全て同じだったら
    i = A
    while i <= B and V[i-1] == min(S): # reverseしてるからこの[i-1]が決定打
        C = C + math.factorial(Vs) // ( math.factorial(Vs - i) * math.factorial(i))
        i += 1
    
else: # 商品価値が均一でなかったのなら
    # nCk = n! /( (n-k)! * k! )に基づきCを計算
    C = math.factorial(Vs) // (math.factorial(Vs - Ss) * math.factorial(Ss) )

print(C)