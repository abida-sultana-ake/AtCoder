M=10**9+7;H,W,A,B=map(int,input().split());Z=C=1
for I in range(H-1):Z=C=C*(W+H-B-2-I)*pow(I+1,M-2,M)%M
for I in range(1,H-A):C=C*(B-1+I)*(H-I)*pow(I*(W+H-B-1-I),M-2,M)%M;Z+=C
print(Z%M)