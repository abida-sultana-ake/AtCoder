W, H, N = map(int, input().split())
w, h = 0, 0

for _ in range(N):
	x, y, a = map(int, input().split())
	if a == 1:
		if w < x:
			w = x
	elif a == 2:
		if W > x:
			W = x
	elif a == 3:
		if h < y:
			h = y
	elif a == 4:
		if H > y:
			H = y

if W-w < 0 or H-h < 0:
	print(0)
else:
	print((W-w)*(H-h))