N = int(input())
Ps = list(map(int, input().split()))
Index=[]
for i in range(N):
    if i+1 == Ps[i]:
        Index.append(i+1)

flag = 1
cnt = 0
L = len(Index)
for i in range(L - 1):
    if flag and (Index[i+1] == Index[i]+1):
        cnt += 1
        flag = 0
    else:
        flag = 1

print(str(L - cnt))