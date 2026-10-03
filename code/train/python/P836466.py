li = list(input())
str = []
for i in range(len(li)):
	if li[i] == '0':
		str.append('0')
	elif li[i] == '1':
		str.append('1')
	else:
		if len(str) != 0:
			str.pop()
		else:
			continue
print(''.join(str))