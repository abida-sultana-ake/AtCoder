s = input()
for i in range(len(s)-2):
	if s[i] == s[i+1]:
		print(i+1, i+2)
		break
	elif s[i] == s[i+2]:
		print(i+1, i+3)
		break
else:
	if s[-2] == s[-1]:
		print(len(s)-1, len(s))
	else:
		print(-1, -1)
