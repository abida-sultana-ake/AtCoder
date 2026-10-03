D=print;R=range;H,W=map(int,input().split());S=[input()for _ in R(H)];T=[[]for _ in R(H)];P=lambda:((X,Y)for Y in R(H)for X in R(W));Q=lambda X,Y:((X+I-1,Y+J-1)for J in R(3)for I in R(3))
for X,Y in P():T[Y]+=['.#'[all(S[J][I]=='#'for I,J in Q(X,Y)if(0<=I<W)&(0<=J<H))]]
if any((S[Y][X]=='.')==any((0<=I<W)&(0<=J<H)and(T[J][I]=='#')for I,J in Q(X,Y))for X,Y in P()):D('impossible')
else:
	D('possible')
	for Y in R(H):D(*T[Y],sep='')