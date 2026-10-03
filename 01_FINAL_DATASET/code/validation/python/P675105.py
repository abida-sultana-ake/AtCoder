# -*- coding: utf-8 -*-

list = []
z = input().split()
n = int(z[0])
q = int(z[1])
for i in range(0,n+10):
	list.append("0")
for i in range(0,q):
	x = input().split()
	l = int(x[0])
	r = int(x[1])
	l -= 1
	r -= 1
	if list[l] == "0":
		list[l] = "1"
	else:
		list[l] = "0"
	if list[r+1] == "0":
		list[r+1] = "1"
	else:
		list[r+1] = "0"
t = "0"
ans = ""
for i in range(0,n):
	if list[i] == "0":
		ans += t
	else:
		if t == "0":
			t = "1"
		else:
			t = "0"
		ans += t
print(ans)