# -*- coding:utf-8 -*-
N = int(input())
a = list(map(int, input().split()))
position = []
for tmp in range(N): #高橋くんのindex=tmp
    candinate = []
    for tmp2 in range(N): #青木くんのindex=tmp2
        if tmp == tmp2:
            continue
        else:
            b = a[min(tmp,tmp2):max(tmp,tmp2)+1]  #区間を得る。
            candinate.append((sum([ b[tmp3] for tmp3 in range(1,len(b),2) ]), tmp2))
    position.append(max(candinate, key=lambda tmp4:tmp4[0])[1]) #bの区間で偶数番目の数値の合計の中から最も大きかったときの青木くんのindexを保存。
maximum = []
for tmp in range(len(position)):
    c = a[min(tmp,position[tmp]):max(tmp,position[tmp])+1]
    maximum.append(sum([ c[tmp2] for tmp2 in range(0, len(c), 2) ]))
print(max(maximum))