#coding=UTF-8

#ゴールに関係無い袋小路で永パされると、探索が収束しない
#かつ答えがinfでないということで 修正

#表にあるかを尋ねるのが重いので
#データ構造を変えて回避する
mozir=input()
hyo=mozir.split(' ')

N=int(hyo[0])
M=int(hyo[1])

#idx番目の都市に繋っている道とコストのタプルを持つリスト
tuuro=[]
# [] はコピーがしんどいものだったりするので
# 参照でごまかしたりしてくる
# なので1個づつ書いている
for idx in range(0,N,1):
    tuuro.append([])


A=[]
B=[]

for idx in range(0,M,1):
    mozir=input()
    hyo=mozir.split(' ')
    tuuro[int(hyo[0])-1].append((int(hyo[1])-1,int(hyo[2])))

#print(tuuro)
#普通の経路探索のようなことをする
#永パ
tmp_score=[None]*N #マイナス点のときもある
tmp_score[0]=0
tansaku=[0]
loopconut=0
while len(tansaku) > 0:
    loopconut=loopconut+1
    next_tansaku=[]
    for mono in tansaku:
        for deru in tuuro[mono]:
            kouho_ten=tmp_score[mono]+deru[1]
            if tmp_score[deru[0]] == None or kouho_ten > tmp_score[deru[0]]:
                tmp_score[deru[0]]=kouho_ten
                next_tansaku.append(deru[0])

    tansaku=list(set(next_tansaku))
    if loopconut==N-1:
        tmp_ans=tmp_score[N-1] #cannot be None
    elif loopconut==2*N-1:
        #period must be eqal or less than N
        if tmp_score[N-1] > tmp_ans:
            print('inf')
            break
        else:
            #関係の無い無限ループ
            print(tmp_score[N-1])
            break
else:
    print(tmp_score[N-1])
