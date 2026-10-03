s = input()
point = 0
p = 0
for l in s:
	if l == "g":
		if p > 0:
			p -= 1
			point += 1
		else:
			p += 1
	else:
		if p > 0:
			p -= 1
		else:
			point -= 1
			p += 1
print(point)