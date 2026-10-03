from math import hypot
txa, tya, txb, tyb, T, V = map(int, input().split())
d = T*V
n = int(input())
for i in range(n):
	x, y = map(int, input().split())
	if hypot((x-txa),(y-tya)) + hypot((x-txb),(y-tyb)) <= d:
		print("YES")
		break
else:
	print("NO")
