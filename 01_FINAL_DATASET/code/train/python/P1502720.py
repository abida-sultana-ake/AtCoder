h,w = map(int, input().split())
n = int(input())
a = map(int, input().split())

l = []

for i,x in enumerate(a):
	for j in range(x):
		l.append(i+1)

for i in range(h):
	t = l[i*w:(i+1)*w]
	if i % 2 == 1:
		t.reverse()
	print(' '.join(map(str, t)))