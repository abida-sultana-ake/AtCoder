n = int(input())
S=[]
for i in range(n):
    S.append(input())

ans = []

if n>1:
    #チェックする文字をS[0]から取得
    for i in S[0]:
        #すべてのSについてチェックする文字の存在判定
        hantei=[]
        for j in range(1,n):
            idx = S[j].find(i)
            hantei.append(idx) #存在する位置をリストに追加
            if idx >= 0: S[j] = S[j][:idx] + S[j][idx+1:] #存在した場合はそれを除去そておく
        if min(hantei) >= 0: ans.append(i)
else:
    ans = [i for i in S[0]]

#辞書順にする
ans.sort()
#文字列にする
ans2 = ''.join(ans)
print(ans2)
