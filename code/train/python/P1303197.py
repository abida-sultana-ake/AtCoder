import sys

x, y = [int(x) for x in sys.stdin.readline().split()]

a = [1, 3, 5, 7, 8, 10, 12]
b = [4, 6, 9, 11]
c = [2]

def inn(x):
	xin = ''
	if x in a:
		xin = 'a'
	elif x in b:
		xin = 'b'
	else:
		xin = 'c'
	return xin

if inn(x) == inn(y):
	print('Yes')
else:
	print('No')