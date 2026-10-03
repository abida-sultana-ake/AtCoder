N = int(input())
S = []
for i in range(N):
    S.append(list(input()))
queue = []
len = len(S[0])

for j in range(len):
    flag = [0 for m in range(N)]
    for k in range(1,N):
        if S[0][j] in S[k]:
            flag[k] = 1
            S[k].remove(S[0][j])
            
    if sum(flag) == N-1:
        queue.append(S[0][j])

queue = sorted(queue)
res = "".join(queue)
        
print(res)
