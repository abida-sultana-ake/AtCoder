# coding: UTF8

#input = "10 40 30"
#l = map(int, input.split())
l = list(map(int, input().split()))
l.sort()
a = l[0]
b = l[1]
c = l[2]

if a + b == c:
	print("Yes")
else:
	print("No")