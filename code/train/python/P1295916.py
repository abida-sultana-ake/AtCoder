H, W = list(map(int, input().split()))
L = []

for i in range(H):
	L.append(input().split())

print("#" * (W + 2))

for i in range(H):
	print("#", end = "")
	print("".join(L[i]), end = "")
	print("#")

print("#" * (W + 2))