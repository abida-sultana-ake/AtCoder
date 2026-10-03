M=10**9+7;N=int(input());E=[set()for _ in range(N)]
while N-1:A,B=map(int,input().split());E[A-1].add(B-1);E[B-1].add(A-1);N-=1
def F(X,Y=-1):
	W,B=1,1
	for I in E[X]-{Y}:C,D=F(I,X);W=(W*(C+D))%M;B=(B*C)%M
	return W,B
print(sum(F(0))%M)