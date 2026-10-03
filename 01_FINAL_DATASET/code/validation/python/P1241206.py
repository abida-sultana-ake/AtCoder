A, B = map(int,input().split())

d = abs(A-B)

res = 0

while 1:
	if d == 0:
		break
	else:
		d = min(abs(d-10), abs(d-5), abs(d-1))
		res += 1

print(res)