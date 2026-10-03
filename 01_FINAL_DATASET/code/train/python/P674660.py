# -*- coding: utf-8 -*-

s = input()
t = int(input())
x = 0
y = 0
cnt = 0
for i in range(0,len(s)):
	if s[i] == 'R':
		x += 1
	elif s[i] == 'L':
		x -= 1
	elif s[i] == 'U':
		y += 1
	elif s[i] == 'D':
		y -= 1
	else:
		cnt = cnt+1
if t == 1:
	print(abs(x)+abs(y)+cnt)
else:
	if abs(x)+abs(y)-cnt > 0:
		print(abs(x)+abs(y)-cnt)
	else:
		if (abs(x)+abs(y)+cnt)%2 == 0:
			print(0)
		else:
			print(1)
