n,*A=map(int,open(0).read().split());n+=1;f=[1]*-~n;r=f[:];M=10**9+7
for a in A:r[a]+=1
i=r.index(3);d=A.index;L=d(i);L+=n-d(i,L+1);*X,=range(1,n+1)
for i in X:f[i]=e=f[i-1]*i%M;r[i]=pow(e,M-2,M)
for k in X:print((f[n]*r[k]*r[n-k]-(k<=L)*(f[L-1]*r[k-1]*r[L-k]))%M)
