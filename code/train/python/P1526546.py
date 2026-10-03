n = int(input())
a = list(map(int, input().split()))
a = sorted(a, reverse=True)
s = 1
count = 0
after = False

for i in range(len(a)-1):
	if after:
		after = False
		pass
	else:
		if count == 2:
			break
		else:
			if a[i] == a[i+1]:
				s = s * a[i]
				count += 1
				after = True

if count == 2:
	print(s)
else:
	print(0)