INF = 10000000000
N = int(input())
nums = [int(x) for x in input().split()]
a,b = nums[0]-1,nums[1]-1
d = [[INF if i != j else 0 for i in range(N)] for j in range(N)]
roots = [0 for i in range(N)]
MOD = 1000000007

def wf():
	for i in range(N):
		for x in range(N):
			for y in range(N):
				d[x][y] = min(d[x][y],d[x][i]+d[i][y])
	return

if __name__ == '__main__':
	
	M = int(input())
	for i in range(M):
		nums = [int(x) for x in input().split()]
		x,y = nums[0]-1,nums[1]-1
		d[x][y] = 1; d[y][x] = 1

	wf()
	
	roots[a] = 1
	for i in range(N):
		for cur in range(N):
			if d[a][cur] != i:
				continue
			for tar in range(N):
				if d[a][tar] == i+1 and d[cur][tar] == 1:
					roots[tar] += roots[cur]
					roots[tar] %= MOD

	print(roots[b])