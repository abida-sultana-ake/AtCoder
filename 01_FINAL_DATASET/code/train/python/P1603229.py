N=int(input())
K=int(input())
x=list(map(int,input().split()))
onewaysum=0
for i in range(N):
    if x[i]<=K-x[i]:
        onewaysum+=x[i]
    else:
        onewaysum+=K-x[i]
print(onewaysum*2) 