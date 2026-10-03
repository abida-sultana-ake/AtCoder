X, A, B = list(map(int, input().split()))

if A - B < -X:
	print('dangerous')
elif A - B >= 0:
	print('delicious')
else:
	print('safe')