N,Q=map(int,input().split())
ht=[0]*(N+1)
ans =''
count = 0
for i in range(Q):
    a,b=map(int,input().split())
    ht[a-1] += 1
    ht[b] -= 1

for i in range(N):
    count += ht[i]
    if count%2==0:
        ans += '0'
    else:
        ans += '1'

print(ans)