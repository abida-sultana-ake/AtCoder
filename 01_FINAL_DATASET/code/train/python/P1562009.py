# Derangement
N = int(input())
p = list(map(int, input().split()))

q = []
for i in range(N):
    if i+1==p[i]:
        q.append(i)
num  = len(q)

cnt = 0
i = 0
while i < num-1:
    if (q[i+1]-q[i]==1):
        cnt+=1
        i+=2
    else:
        i+=1

print(num-cnt)