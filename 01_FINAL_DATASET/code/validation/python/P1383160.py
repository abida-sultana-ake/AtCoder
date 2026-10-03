#coding=UTF-8

mozir=input()
hyo=mozir.split(' ')

N=int(hyo[0])
K=int(hyo[1])

T=[]
for idx in range(0,N,1):
    mozir=input()
    hyo=mozir.split(' ')
    
    T.append([int(mono) for mono in hyo])

tmp_atai=[0]

for idx in range(0,N,1):
    next_atai=[]
    for mae in tmp_atai:
        for zure in T[idx]:
            next_atai.append(mae^zure)

    tmp_atai=next_atai

if 0 in tmp_atai:
    print('Found')
else:
    print('Nothing')
