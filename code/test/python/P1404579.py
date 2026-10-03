N = int(input())
N %= 30
lis = [1, 2, 3, 4, 5, 6]

for i in range(0, N):
	s = (i % 5) + 1;
	t = (i % 5) + 2;
	a = lis[s-1];
	lis[s-1] = lis[t-1];
	lis[t-1] = a;


for i in range(0, 6):
	print(lis[i], end = "")
print()