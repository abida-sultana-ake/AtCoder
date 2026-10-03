A, B, C, D = map(int,input().split())

if(B < C or D < A):
	print(0)

else:
	if(A > C):
		E = A
	else:
		E = C

	if(B > D):
		F = D
	else:
		F = B

	print(F - E)
