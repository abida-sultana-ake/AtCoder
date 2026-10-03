M=10**9+7;F=[pow(X,M-2,M)for X in range(2*10**5)];H,W,A,B=map(int,input().split());Z=C=1
for I in range(H-1):Z=C=C*(W+H-B-2-I)*F[I+1]%M
for I in range(1,H-A):C=C*(B-1+I)*F[I]*(H-I)*F[W+H-B-1-I]%M;Z=(Z+C)%M
print(Z)