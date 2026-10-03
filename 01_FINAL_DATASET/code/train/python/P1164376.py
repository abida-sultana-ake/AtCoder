S = input()
ans=[]
for c in S:
	if c == 'B':
		if len(ans) > 0:
			ans.pop()
	else:
		ans.append(c)
s = ''.join(ans)
print(s)