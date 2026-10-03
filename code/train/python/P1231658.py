import sys
n,m = [int(x) for x in sys.stdin.readline().split()]
x = [int(x) for x in sys.stdin.readline().split()]
y = [int(x) for x in sys.stdin.readline().split()]
r = 0
mod = 10**9+7
def sumof(a,b):
	s = 0
	for i in range(a):
		s += (2*(i+1)-a-1)*b[i]
		s %= mod
	return s
r = (sumof(n,x)*sumof(m,y))%mod
print(r)