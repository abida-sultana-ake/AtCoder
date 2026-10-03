n = int(input())
A = [[0 for i in[None]*12]for i in[None]*25]
for i in[None]*n:
    a,b = map(int,input().split('-'))
    st = a//100 *60 + (a%100 - a%5)
    en = b//100 *60 + (b%100 + (5-b%5)%5)
    A[st//60][st%60//5]+=1
    A[en//60][en%60//5]-=1
con = 0
f = 0
for i in range(0,1450,5):
    con += A[i//60][i%60//5]
    if con > 0 and f == 0:
        s = i//60 *100 + i%60
        f = 1
    if con == 0 and f == 1:
        e = i//60 *100 + i%60
        f = 0
        print("{:04d}-{:04d}".format(s,e))