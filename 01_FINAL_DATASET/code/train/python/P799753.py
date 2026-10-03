s = int(input());
x = s
y = s
y += 1
x *= x
y *= y
base = 1
ans = 0
while (True):
	z = (x+base-1)//base
	if (z*base < y):
		ans = z
		base *= 100
		continue
	break

print(ans)
