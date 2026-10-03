n, a, b = map(int, input().split())

x = list(map(int, input().split()))

y = []
for i in range(1, len(x)):
	y.append(a*(x[i] - x[i-1]))

for i, l in enumerate(y):
	if l > b:
		y[i] = b

print(sum(y))