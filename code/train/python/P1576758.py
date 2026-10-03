#a = map(int,raw_input().strip().split())
a = raw_input()
p = False
for x in a:
	if x == '9':
		p = True
if p:
	print("Yes")
else:
	print("No")