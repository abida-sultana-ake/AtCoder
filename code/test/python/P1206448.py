import sys
def solve():
	N,K = [int(i) for i in input().split()]
	S = [int(sys.stdin.readline().rstrip()) for i in range(N)]
	if(0 in S):
		print(N)
		return
	lx = rx = 0
	ans = 1
	maxs = 0
	while rx < N:
		# print(lx,rx,ans)
		ans *= S[rx]
		if ans <= K:
			maxs = max(maxs , rx-lx+1)
			rx += 1
		elif rx > lx:
			ans /= S[lx]
			lx += 1
			ans /= S[rx]
		else:
			lx += 1
			rx = lx
			ans = 1
		
	print(maxs)

if __name__ == '__main__':
	solve()