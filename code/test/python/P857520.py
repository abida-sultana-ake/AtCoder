R=range;(N,A),(*X,)=(map(int,input().split())for _ in R(2));C=[51*N*[0]for _ in R(N+1)];C[0][0]=1
for I in R(N):
	for J in R(N)[::-1]:
		for K in R(50*N)[::-1]:
			if C[J][K]:C[J+1][K+X[I]]+=C[J][K]
print(sum(C[I][I*A]for I in R(1,N+1)))