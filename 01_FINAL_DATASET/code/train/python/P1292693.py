data = input()
data += '+'

flg = False
tmp = 0
count = 0

for c in data:
	if flg is True:
		tmp *= int(c)
		flg = False
		continue
	if c == '*':
		flg = True
		continue
	elif c == '+':
		if tmp != 0:
			count += 1
	else:
		tmp = int(c)

print(count)