N = int(input())
a1 = list(input())
a2 = list(input())
t, i = 0, 0
x = 1

while (i < len(a1) - 1):
	if(t == 0):
		if(a1[i] == a1[i + 1]):
			x = x*6
			t = 1
			i += 2
		
		else:
			x = x*3
			t = 2
			i += 1

			if(i == len(a1) - 1):
				x = x*2

		continue

	if(t == 1):
		if(a1[i] == a1[i + 1]):
			x = x*3
			t = 1
			i += 2

		else:
			x = x*1
			t = 2
			i += 1

			if(i == len(a1) - 1):
				x = x*2


		continue

	if(t == 2):
		if(a1[i] == a1[i + 1]):
			x = x*2
			t = 1
			i += 2

		else:
			x = x*2
			t = 2
			i += 1

			if(i == len(a1) - 1):
				x = x*2

		continue


if(len(a1) == 1):
	print(3)

else:
	print(x % 1000000007)