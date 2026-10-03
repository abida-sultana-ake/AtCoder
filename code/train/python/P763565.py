h, w = [int(i) for i in input().split()]
m = [[0,0],[1,0],[1,1],[0,1],[-1,1],[-1,0],[-1,-1],[0,-1],[1,-1]]




img = []
for hi in range(h):
	img.append(list(input()))


import copy
check = copy.deepcopy(img)
res = copy.deepcopy(img)


for i in range(h):
	for j in range(w):
		if all([img[i+x][j+y] == "#" for x,y in m if 0 <= i+x < h and 0 <= j+y < w]):
			a = [[i+x, j+y] for x,y in m if 0 <= i+x < h and 0 <= j+y < w]
			for xx, yy in a:
				check[xx][yy] = "."
				if res[xx][yy] != "*":
					res[xx][yy] = "." 
			res[i][j] = "*"


if all([j == "." for i in check for j in i]):
	print("possible")
	print("\n".join(["".join(["#" if j=="*" else "." for j in i]) for i in res]))
else:
	print("impossible")

