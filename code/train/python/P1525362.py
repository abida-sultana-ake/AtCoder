N = int(input())
a = list(map(int, input().split()))

a = sorted(a)
i = len(a) - 1
b = []

while (i - 1 >= 0):
	if (a[i] == a[i - 1]):
		b.append(a[i - 1])
		i -= 2

	else:
		i -= 1

	if(len(b) == 2):
		break


if(len(b) == 2):
	print(b[0]*b[1])

else:
	print(0)