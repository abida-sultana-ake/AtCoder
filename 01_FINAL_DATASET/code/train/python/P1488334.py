N = int(input())
a = list(map(int,input().split()))
na = nb = nc = 0
for num in a:
	if num % 4 == 0:
		nc+=1
	elif num % 2 == 0:
		nb+=1
	else:
		na+=1
if nb > 0:
	if nc >= na:
		print("Yes")
	else:
		print("No")
if nb == 0:
	if nc >= na-1:
		print("Yes")
	else:
		print("No")