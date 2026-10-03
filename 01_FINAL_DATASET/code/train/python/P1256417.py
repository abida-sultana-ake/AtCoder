
N,W = map(int, input().split())

w = [0 for i in range(N)]
v = [0 for i in range(N)]
Wsum = [0 for i in range(N+1)]
Vsum = [0 for i in range(N+1)]

for i in range(N):
    w[i],v[i] = map(int, input().split())
Wmin = min(w)

w.insert(0,"0")
v.insert(0,"0")


for i in range(N):
    Wsum[i+1] = Wsum[i] + w[i+1]
    Vsum[i+1] = Vsum[i] + v[i+1]


nap_memo = {}

#i番目の品物まで含み制約W2のナップサック問題の最適解
def nap(i,W2):
    #重複計算を避けるためnap(i,W2)を保持
    key = str(i) + ':' + str(W2)
    if key in nap_memo:
        return nap_memo[key]
    #品物0個のときは価値は0
    elif i == 0:
        r = 0
    #制約0のときも価値は0
    elif W2 < Wmin:
        r = 0
    #w[i]がW2を超えるときはi番目の品物は不必要
    elif W2 < w[i]:
        r = nap(i-1,W2)
    #品物の重さ全部足して制約以下なら全部足したものが価値で良い
    elif Wsum[i] <= W2:
        r = Vsum[i]
    #i番目の品物をナップサックに入れるか入れないか
    else:
        r = max( nap(i-1,W2-w[i])+v[i] , nap(i-1,W2) )
    
    nap_memo[key] = r
    return r
    
            
print(nap(N,W))
