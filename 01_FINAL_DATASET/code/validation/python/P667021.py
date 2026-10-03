n = int(input())
ls = []
for _ in range(n):
	ls.append(list(map(int, input().split())))

maxtime = 0
for i, li in enumerate(ls):
	for lj in ls[i+1:]:
		xi, yi, ci = li
		xj, yj, cj = lj
		
		d = max(abs(xi - xj), abs(yi - yj))
		time = ci * cj * d / (ci + cj)
		maxtime = max(time, maxtime)

print(maxtime)