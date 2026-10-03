n,*A=map(int,open(0).read().split())
for i in range(n-1):A[i+1]+=A[i]
print(min(abs(A[n-1]-A[i]*2)for i in range(n-1)))