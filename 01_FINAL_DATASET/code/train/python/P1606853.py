N,K = list(map(int,input().split()))
R = list(map(int,input().split()))

R = sorted(R)
ans = 0

for i in range(N-K,N):
    ans = (ans+R[i])/2
print(ans) 