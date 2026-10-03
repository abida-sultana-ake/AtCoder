l = [0]*100005
n = int(raw_input())
for x in xrange(n):
	a = map(int,raw_input().strip().split())
	for y in xrange(a[0],a[1]+1):
		l[y] = 1
ans = 0
for x in l:
	if x == 1:
		ans += 1
print(ans)