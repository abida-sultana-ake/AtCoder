n = int(input())
a = list(map(int, input().split()))

def g(mid):
	for i in range(n):
		if f(mid * n + i):
			return True
	return False	

def f(mid):
	over = 0
	for x in a:
		over += (x + mid + 1) // (n + 1)
	return over <= mid

ok = 10 ** 30
ng = -1

while ok - ng > 1:
	mid = (ok + ng) // 2
	if g(mid):
		ok = mid
	else:
		ng = mid

for i in range(n):
	if f(ok * n + i):
		print(ok * n + i)
		break