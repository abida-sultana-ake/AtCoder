n = int(input())
card = list(map(int, input().split()))
c_set = set(card)

if len(c_set)%2 != 0:
	print(len(c_set))
else:
	print(len(c_set) - 1)