N = int(input())
R = [1,400,800,1200,1600,2000,2400,2800,3200,4801]
r = [0] * 10
A = list(map(int,input().split()))
for a in A:
	m = 0
	M = 9
	while True:
		n = (m + M) // 2
		if a < R[n]:
			M = n
		elif a >= R[n + 1]:
			m = n
		else:
			break
	r[n] += 1
cnt = 0
for i in r[:-2]:
	if i > 0:
		cnt += 1
if cnt == 0:
	max_cnt = r[8]
	cnt = 1
else:
	max_cnt = cnt + r[8]
print(cnt,max_cnt)